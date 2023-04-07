package com.example.poems_app.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FilenameUtils;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.poems_app.FileFormatHelper;
import com.example.poems_app.repositories.ChoiceRepository;
import com.example.poems_app.repositories.ContentItemRepository;
import com.example.poems_app.repositories.OrigRepository;
import com.example.poems_app.repositories.RegRepository;
import com.example.poems_app.repositories.XmlPoemRepository;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.ContentItemChoice;
import com.example.poems_app.xml.Orig;
import com.example.poems_app.xml.Reg;
import com.example.poems_app.xml.XmlPoem;

@Service
public class XmlPoemService {

	@Autowired
	private XmlPoemRepository xmlPoemRepository;
	
	@Autowired
	private ContentItemRepository contentItemRepository;
	
	@Autowired
	private ContentItemsExtractor ciExtractor;
	
	@Autowired
	private ChoiceRepository choiceRepository;
	
	@Autowired
	private OrigRepository origRepository;
	
	@Autowired
	private RegRepository regRepository;
		
	public ContentItemChoice getChoiceById(int id) throws Exception {
		return choiceRepository.findById(id).orElseThrow(Exception::new);
	}
	
	public XmlPoem getXmlPoemByContentItemId(int id) throws Exception {
		return xmlPoemRepository.findByContentItems_id(id).orElseThrow(Exception::new);
	}
	
	public ContentItem getContentItemByTextId(String textId) throws Exception {
		return contentItemRepository.findByTextId(textId).orElseThrow(Exception::new);
	}
	
	public Iterable<ContentItem> getContentItems() {
		return contentItemRepository.findAll();
	}
	
	public Iterable<XmlPoem> findAllXmlPoems() {
		return xmlPoemRepository.findAll();
	}
	
	public List<ContentItem> parsePoem(XmlPoem xmlPoem) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		List<ContentItem> contentItems = new ArrayList<ContentItem>();
		if(xmlPoem.getFilepath() == null) {
			return contentItems;
		}
		File file = new File(xmlPoem.getFilepath());
		if(file.exists()) {
			contentItems = getContentItems(file);
		}
		return contentItems;
	}
	
	private List<ContentItem> getContentItems(File file) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, XPathExpressionException {
		List<ContentItem> contentItems = ciExtractor.getContentItems(file);
		return contentItems;
	}
	
	public void parseAndIndexPoem(XmlPoem xmlPoem) throws ParserConfigurationException, SAXException, IOException, SolrServerException {
		File file = new File(xmlPoem.getFilepath());
		if(FileFormatHelper.hasXMLFormat(file)) {
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
		        	    solr.add("techproducts",inputDoc);
		        	    solr.commit("techproducts");    
		        	}
		        }
		    }
		}
	}
	
	//TODO this should be read from a config file
	private String folder = "C:\\Users\\pontu\\";
	
	public void deleteXmlPoemById(int id) {
		xmlPoemRepository.deleteById(id);
	}
	
	
	public XmlPoem saveXmlPoem(XmlPoem poem) {
		return xmlPoemRepository.save(poem);
	}
	
	
	public XmlPoem savePoemWithFile(XmlPoem poem, MultipartFile file) throws ParserConfigurationException, SAXException, IOException, SolrServerException, XPathExpressionException {
		
		String filePath = FilenameUtils.concat(folder, poem.getName() + ".xml");
		File xmlFile = new File(filePath);
		try {
		    file.transferTo(xmlFile);
		}
		catch(IOException e) {
			filePath = null;
		}
		List<ContentItem> contentItemList = getContentItems(xmlFile);
		
		Iterable<ContentItem> ciList = contentItemRepository.saveAll(contentItemList);
		for(ContentItem ci : ciList) {
			ci.setChoice(choiceRepository.save(ci.getChoice()));
		}
		Iterable<ContentItem> persistentList = contentItemRepository.saveAll(contentItemList);
		HashSet<ContentItem> contentItemSet = new HashSet<ContentItem>((List)persistentList);
		poem.setContentItems(contentItemSet);
		
		return xmlPoemRepository.save(poem);
	}

	public XmlPoem getXmlPoemById(int id) throws Exception {
		return xmlPoemRepository.findById(id).orElseThrow(Exception::new);
	}
}
