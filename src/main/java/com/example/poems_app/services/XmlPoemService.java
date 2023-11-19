package com.example.poems_app.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.io.FilenameUtils;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.poems_app.FileFormatHelper;
import com.example.poems_app.XmlPoemCreatedMessage;
import com.example.poems_app.XmlPoemCreationRequest;
import com.example.poems_app.repositories.ContentItemRepository;
import com.example.poems_app.repositories.XmlPoemRepository;
import com.example.poems_app.xml.AuthorSection;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Letter;
import com.example.poems_app.xml.Part;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.XmlPoem;

@Service
public class XmlPoemService {

	@Autowired
	private XmlPoemRepository xmlPoemRepository;

	@Autowired
	private ContentItemRepository contentItemRepository;

	@Autowired
	private XmlPoemParser xmlParser;

	@Autowired
	private XmlPoemIndexer xmlPoemIndexer;
	
	/**@Autowired
	private SegIndexer segIndexer;
*/
	/**public XmlPoem getXmlPoemByContentItemId(int id) throws Exception {
		return xmlPoemRepository.findByContentItems_id(id).orElseThrow(Exception::new);
	}*/

	public ContentItem getContentItemByTextId(String textId) throws Exception {
		return contentItemRepository.findByTextId(textId).orElseThrow(Exception::new);
	}

	public Iterable<ContentItem> getContentItems() {
		return contentItemRepository.findAll();
	}

	public Iterable<XmlPoem> findAllXmlPoems() {
		return xmlPoemRepository.findAll();
	}

	public List<Part> getPartsByXmlPoemId(int id) {
		return xmlPoemRepository.findById(id).orElseThrow()
				.getText().getBody().getParts();
	}
	
	public List<Letter> getLettersByXmlPoemId(int id) {
		List<Letter> letters = getPartsByXmlPoemId(id).stream().map(a -> a.getLetters()).flatMap(List::stream).collect(Collectors.toList());
		return letters;
	}
	
	public List<AuthorSection> getAuthorSectionsByXmlPoemId(int id) {
		List<AuthorSection> authorSections = getLettersByXmlPoemId(id).stream().map(a -> a.getAuthors()).flatMap(List::stream).collect(Collectors.toList());
		return authorSections;
	}
	
	public List<Seg> getContentItemsByXmlPoemId(int id) {   
		List<Seg> segments = getAuthorSectionsByXmlPoemId(id).stream().map(a -> a.getSegments()).flatMap(List::stream).collect(Collectors.toList());
		return segments;
	}

	public void parseAndIndexPoem(XmlPoem xmlPoem)
			throws ParserConfigurationException, SAXException, IOException, SolrServerException {
		File file = new File(xmlPoem.getFilepath());
		if (FileFormatHelper.hasXMLFormat(file)) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new BufferedInputStream(new FileInputStream(file)));
			HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
			NodeList nodeList = doc.getElementsByTagName("seg");
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println("In seg");
				Node current = nodeList.item(i);
				if (current.getNodeType() == Node.ELEMENT_NODE) {
					if (current.getAttributes().getNamedItem("type").getTextContent().equals("contentItem")) {
						SolrInputDocument inputDoc = new SolrInputDocument();
						inputDoc.addField("id", current.getAttributes().getNamedItem("xml:id").getNodeValue());
						inputDoc.addField("cat", "seg");
						inputDoc.addField("text", current.getTextContent());
						solr.add("techproducts", inputDoc);
						solr.commit("techproducts");
					}
				}
			}
		}
	}

	// TODO this should be read from a config file

	@Value(value = "${xml.storage.directory}")
	private String folder;

	public void deleteXmlPoemById(int id) {
		xmlPoemRepository.deleteById(id);
	}

	public XmlPoem saveXmlPoem(XmlPoem poem) {
		return xmlPoemRepository.save(poem);
	}

	public XmlPoem savePoemWithFile(XmlPoem poem, MultipartFile file) throws ParserConfigurationException, SAXException,
			IOException, SolrServerException, XPathExpressionException {

		String filePath = FilenameUtils.concat(folder, poem.getName() + ".xml");
		File xmlFile = new File(filePath);

		if (xmlFile.createNewFile()) {
			try {
				file.transferTo(xmlFile);
			} catch (IOException e) {
				filePath = null;
			}
			poem = xmlParser.XmlPoem(xmlFile);
			poem.setFilepath(filePath);

			poem = xmlPoemRepository.save(poem);
			xmlPoemIndexer.index(poem);
			
			List<Seg> segs = getContentItemsByXmlPoemId(poem.getId());
			/**for (Seg seg : segs) {
				segIndexer.index(seg);
			}*/
//			segIndexer.indexAll(segs);

			return poem;
		} else {
			return null;
		}
	}

	private static final String TEST_TOPIC = "quickstart-events";
	private static final String CREATED_TOPIC = "created-poem";

	@Autowired
	private KafkaTemplate<String, XmlPoemCreationRequest> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, XmlPoemCreatedMessage> createdTemplate;

	/**
	 * Starts process to save Poem by sending message to kafka broker.
	 * 
	 * @param file File to be parsed to poem
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public void startSavePoem(MultipartFile file) throws IllegalStateException, IOException {
		startSavePoem(file,file.getName());
	}
	
	/**
	 * Starts process to save Poem by sending message to kafka broker.
	 * 
	 * @param file File to be parsed to poem
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public void startSavePoem(MultipartFile file, String fileName) throws IllegalStateException, IOException {
		String filePath = FilenameUtils.concat(folder, fileName);
		file.getOriginalFilename();
		File persistent_file = new File(filePath);
		if (persistent_file.createNewFile()) {
			file.transferTo(persistent_file);
			sendMessage(persistent_file.getAbsolutePath());
		}
	}

	@KafkaListener(topics = TEST_TOPIC, containerFactory = "xmlPoemCreationRequestKafkaListenerContainerFactory")
	public void xmlPoemCreationRequestListener(XmlPoemCreationRequest request) throws XPathExpressionException,
			ParserConfigurationException, SAXException, IOException, SolrServerException {
		if (request.getFilePath() != null) {
			try {
				XmlPoem poem = savePoemFromFile(request.getFilePath());
				sendXmlPoemCreatedMessage(request.getId(), poem);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private XmlPoemCreationRequest sendMessage(String filePath) {
		XmlPoemCreationRequest request = new XmlPoemCreationRequest(filePath, 5);
		kafkaTemplate.send(TEST_TOPIC, request);
		return request;
	}

	private XmlPoemCreatedMessage sendXmlPoemCreatedMessage(int creationRequestId, XmlPoem poem) {
		XmlPoemCreatedMessage createdMessage = new XmlPoemCreatedMessage(creationRequestId, poem.getId(),
				poem.getFilepath(), poem.getName());
		createdTemplate.send(CREATED_TOPIC, createdMessage);
		return createdMessage;
	}

	public XmlPoem savePoemFromFile(String filepath) throws Exception {

		File xmlFile = new File(filepath);

		if (xmlFile.isFile()) {
			XmlPoem poem = xmlParser.XmlPoem(xmlFile);
			poem.setFilepath(filepath);
			poem = xmlPoemRepository.save(poem);
			xmlPoemIndexer.index(poem);
			return poem;
		} else {
			throw new Exception("File " + filepath + " could not be parsed to and saved as xmlpoem");
		}
	}

	public XmlPoem savePoemWithFile(MultipartFile file) throws ParserConfigurationException, SAXException, IOException,
			SolrServerException, XPathExpressionException {

		String filePath = FilenameUtils.concat(folder, "5");
		File xmlFile = new File(filePath);
		try {
			file.transferTo(xmlFile);
		} catch (IOException e) {
			filePath = null;
		}
		XmlPoem poem = xmlParser.XmlPoem(xmlFile);
		poem.setFilepath(filePath);

		poem = xmlPoemRepository.save(poem);
		xmlPoemIndexer.index(poem);

		return poem;
	}

	public XmlPoem getXmlPoemById(int id) throws Exception {
		return xmlPoemRepository.findById(id).orElseThrow(Exception::new);
	}
}
