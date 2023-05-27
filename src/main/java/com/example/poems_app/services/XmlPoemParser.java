package com.example.poems_app.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.poems_app.FileFormatHelper;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

@Service
public class XmlPoemParser {

	@Autowired
	private ContentItemsExtractor ciExtractor;

	private String getTitle(NodeList titleStatements) {
		for (int i = 0; i < titleStatements.getLength(); i++) {
			Node node = titleStatements.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				NodeList nodes = node.getChildNodes();
				for (int y = 0; y < nodes.getLength(); y++) {
					Node titleNode = nodes.item(y);
					if (titleNode.getNodeType() == Node.ELEMENT_NODE) {
						if (titleNode.getNodeName().equals("title")) {
							return titleNode.getTextContent();
						}
					}
				}
			}
		}
		return "";
	}

	public XmlPoem XmlPoem(File file) throws FileNotFoundException, XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		XmlPoem poem = new XmlPoem();
		if (FileFormatHelper.hasXMLFormat(file)) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new BufferedInputStream(new FileInputStream(file)));
			NodeList titleStatements = doc.getElementsByTagName("titleStmt");
			String title = getTitle(titleStatements);
			poem.setName(title);
			NodeList cis = doc.getElementsByTagName("seg");
			List<ContentItem> contentItems = ciExtractor.getContentItems(doc, cis);
			poem.setContentItems(new HashSet<ContentItem>(contentItems));
			//Synchronization
			poem.getContentItems().forEach(ci -> ci.setXmlPoem(poem));
		}
		return poem;
	}

}
