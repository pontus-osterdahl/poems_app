package com.example.poems_app.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.poems_app.FileFormatHelper;
import com.example.poems_app.xml.Apophthegm;
import com.example.poems_app.xml.ApophthegmText;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Orig;
import com.example.poems_app.xml.Reg;
import com.example.poems_app.xml.XmlPoem;

@Service
public class ApophthegmTextExtractor {

	@Autowired
	private XmlPoemService xmlPoemService;

	public Apophthegm extractApophtegmText(String textId) throws Exception {

		ContentItem ci = xmlPoemService.getContentItemByTextId(textId);

		XmlPoem xmlPoem = ci.getXmlPoem();
		String filePath = xmlPoem.getFilepath();
		
		System.out.print(filePath);

		if (filePath == null) {
			throw new Exception("No file is aved for textid " + textId);
		}

		File file = new File(filePath);
		if (!file.exists()) {
			throw new Exception("No file is aved for textid " + textId);
		}
		
		return extractFromFile(textId, file);
	}

	private Apophthegm extractFromFile(String textId, File file) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, XPathExpressionException {
		Apophthegm apophthegm = new Apophthegm();
		if (FileFormatHelper.hasXMLFormat(file)) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new BufferedInputStream(new FileInputStream(file)));
			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList relations = (NodeList) xPath.compile("//seg[@type='contentItem' and @id='" + textId + "']/choice")
					.evaluate(doc, XPathConstants.NODESET);
			for (int n = 0; n < relations.getLength(); n++) {
				Node relation = relations.item(n);
				NodeList nodes = relation.getChildNodes();
				for (int i = 0; i < nodes.getLength(); i++) {
					if (nodes.item(i).getNodeName().equals("orig")) {
						Orig orig = new Orig();
						orig.setText(nodes.item(i).getTextContent());
						apophthegm.setOrig(orig);
					} else if (nodes.item(i).getNodeName().equals("reg")) {
						Reg reg = new Reg();
						reg.setText(nodes.item(i).getTextContent());
						apophthegm.setReg(reg);
					}
				}
			}
		}
		return apophthegm;
	}
}
