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
	
	public List<ContentItem> parsePoem(XmlPoem xmlPoem) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
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
	
	private List<ContentItem> getContentItems(File file) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		List<ContentItem> contentItems = new ArrayList<ContentItem>();
		ContentItemChoice choice = null;
		if(FileFormatHelper.hasXMLFormat(file)) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    Document doc = builder.parse(new BufferedInputStream(new FileInputStream(file)));
		    NodeList nodeList = doc.getElementsByTagName("seg");
		    for (int i = 0; i < nodeList.getLength(); i++) {
		    	System.out.println("In seg");
		        Node current = nodeList.item(i);
		        if (current.getNodeType() == Node.ELEMENT_NODE) {
		        	if (current.getAttributes().getNamedItem("type").getTextContent().equals("contentItem")) {
		        	    String id = current.getAttributes().getNamedItem("xml:id").getNodeValue();		        	    
		        	    NodeList choiceList = current.getChildNodes();
		        	    for(int y = 0; y < choiceList.getLength(); y++) {
		        	    	Node choiceNode = choiceList.item(y);
		        	    	if(choiceNode != null && choiceNode.getNodeType() == Node.ELEMENT_NODE) {
		        	    		if(choiceNode.getNodeName().equals("choice"))
		        	    		{
		        	    			System.out.println("CHOICE");
		        	    			choice = new ContentItemChoice();
		        	    			Orig orig = null;
		        	    			Reg reg = null;
		        	    			NodeList edChoiceList = choiceNode.getChildNodes();
		        	    		    for(int x = 0; x < edChoiceList.getLength(); x++) {
		        	    		    	
		        	    		    	Node edChoiceNode = edChoiceList.item(x);
		        	    		    	if(edChoiceNode.getNodeName().equals("orig")) {
				        	    			orig = new Orig();
				        	    			System.out.println("ORIG");
				        	    			System.out.println(edChoiceNode.getTextContent());
				        	    			orig.setText(edChoiceNode.getTextContent());
				        	    			//orig.setText(edChoiceNode.getTextContent());
				        	    			//orig.setText("hallo_orig");
				        	    		}
				        	    		if(edChoiceNode.getNodeName().equals("reg")) {
				        	    			reg = new Reg();
				        	    			System.out.println("Reg");
				        	    			System.out.println(edChoiceNode.getTextContent());
				        	    			reg.setText(edChoiceNode.getTextContent());
				        	    			//reg.setText(edChoiceNode.getTextContent().replaceAll("[^\\u0000-\\uFFFF]", ""));
				        	    		    //reg.setText("hallo_reg");
				        	    		}
		        	    		    }
		        	    		    if(orig != null) {
		        	    		    	choice.setOrig(origRepository.save(orig));
		        	    		    }
		        	    		    if(reg != null)  {
		        	    		    	choice.setReg(regRepository.save(reg));
		        	    		    }
		        	    		}		        	    				        	    		
		        	    	}
		        	    }
		        	    
//		        	    String orig = current.getChildNodes().
//		        	    String text = current.getTextContent();
//		        	    if(id != null && text != null) {
		        	    if(id != null) {
		        	    	ContentItem item = new ContentItem();
		        	    	item.setTextId(id);
		        	    	ContentItem persistentItem = contentItemRepository.save(item);
		        	    	if(choice != null) {
		        	    		choice.setContentitem(persistentItem);
		        	    		ContentItemChoice persistentChoice = choiceRepository.save(choice);
		        	    		persistentItem.setChoice(persistentChoice);
		        	    		persistentItem = contentItemRepository.save(persistentItem);
		        	    		//System.out.println(persistentChoice.getId());
		        	    		//item.setChoice(persistentChoice);
		        	    		//persistentChoice.setContentitem(item);
		        	    	}
		        	    	contentItems.add(persistentItem);
//		        	    	item.setText(text);
		        	    	
		        	    }
		        	}
		        }
		    }
		}
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
	
	public XmlPoem savePoemWithFile(XmlPoem poem, MultipartFile file) throws ParserConfigurationException, SAXException, IOException, SolrServerException {
		
		String filePath = FilenameUtils.concat(folder, poem.getName() + ".xml");
		File xmlFile = new File(filePath);
		try {
		    file.transferTo(xmlFile);
		}
		catch(IOException e) {
			filePath = null;
		}
//		List<ContentItem> contentItemList = parsePoem(poem);
		List<ContentItem> contentItemList = getContentItems(xmlFile);
		HashSet<ContentItem> contentItemSet = new HashSet<ContentItem>(contentItemList);
		poem.setContentItems(contentItemSet);
		
		
		XmlPoem savedPoem = xmlPoemRepository.save(poem);
		//parseAndIndexPoem(poem);
		return xmlPoemRepository.save(poem);
//		return savedPoem;
	}

	public XmlPoem getXmlPoemById(int id) throws Exception {
		return xmlPoemRepository.findById(id).orElseThrow(Exception::new);
	}
	
}
