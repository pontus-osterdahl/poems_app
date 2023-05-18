package com.example.poems_app.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
import org.w3c.dom.Element;
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
			throw new Exception("No file is saved for textid " + textId);
		}

		File file = new File(filePath);
		if (!file.exists()) {
			throw new Exception("No file is saved for textid " + textId);
		}

		return extractFromFile(textId, file);
	}

	public List<Apophthegm> extractApophthegmTexts(XmlPoem poem) throws Exception {
		String filePath = poem.getFilepath();

		System.out.print(filePath);

		if (filePath == null) {
			throw new Exception("No file exists");
		}

		File file = new File(filePath);
		if (!file.exists()) {
			throw new Exception("No file exists");
		}

		List<Apophthegm> apophthegms = new ArrayList<Apophthegm>();
		if (FileFormatHelper.hasXMLFormat(file)) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new BufferedInputStream(new FileInputStream(file)));

			Element root = doc.getDocumentElement();
			NodeList cis = root.getElementsByTagName("seg");

			for (int i = 0; i < cis.getLength(); i++) {

				if (cis.item(i).getAttributes().getNamedItem("type").getNodeValue().equals("contentItem")) {
					Apophthegm a = new Apophthegm();

					String id = cis.item(i).getAttributes().getNamedItem("xml:id").getNodeValue();
					a.setTextId(id);
					Node node = cis.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) node;
						NodeList nodes = e.getElementsByTagName("orig");
						for (int o_i = 0; o_i < nodes.getLength() && o_i < 1; o_i++) {
							Orig orig = new Orig();
							orig.setText(nodes.item(o_i).getTextContent());
							a.setOrig(orig);
						}

						nodes = e.getElementsByTagName("reg");
						for (int o_i = 0; o_i < nodes.getLength() && o_i < 1; o_i++) {
							Reg reg = new Reg();

							String tmpCriticalApparatus = "";
							NodeList withinOrig = nodes.item(o_i).getChildNodes();
							for (int u = 0; u < withinOrig.getLength(); u++) {
								Node withinOrigNode = withinOrig.item(u);
								if (withinOrigNode.getNodeType() == Node.ELEMENT_NODE) {
									if (withinOrigNode.getNodeName().equals("choice")) {
										String origReading = "";
										String correction = "";
										NodeList withinInnerChoiceList = withinOrigNode.getChildNodes();
										for (int z = 0; z < withinInnerChoiceList.getLength(); z++) {
											Node aNode = withinInnerChoiceList.item(z);
											if (aNode.getNodeType() == Node.ELEMENT_NODE
													&& aNode.getNodeName().equals("sic")) {
												origReading = aNode.getTextContent();
												aNode.setTextContent("");
											} else if (aNode.getNodeType() == Node.ELEMENT_NODE
													&& aNode.getNodeName().equals("corr")) {
												correction = aNode.getTextContent();
											}
										}
										System.out.println("CritApp: " + correction + " : " + origReading);
										if (correction != "" && origReading != "") {
											String addedValue = tmpCriticalApparatus != "" ? " | " : "";
											tmpCriticalApparatus += addedValue + correction + " : " + origReading;
										}
									}
								}

							}
							reg.setText(nodes.item(o_i).getTextContent());
							System.out.println(tmpCriticalApparatus);
							reg.setCriticalApparatus(tmpCriticalApparatus);
							a.setReg(reg);
						}

					}
					
					
					try{ 
						ContentItem tmpCI = xmlPoemService.getContentItemByTextId(a.getTextId());
						List<String> relations = Optional.ofNullable(tmpCI.getRelations()).orElse(Collections.emptyList());
						a.setRelations(relations);					
						apophthegms.add(a);
					}
					catch (Exception e) {
						System.out.println("Apophthegm with ID " + a.getTextId() + " is not stored in database as CI");
					}

				}
			}

			// XPath xPath = XPathFactory.newInstance().newXPath();
			/**
			 * NodeList relations = (NodeList)
			 * xPath.compile("//seg[@type='contentItem']/choice") .evaluate(doc,
			 * XPathConstants.NODESET); for (int n = 0; n < relations.getLength(); n++) {
			 * Apophthegm a = new Apophthegm(); Node relation = relations.item(n); NodeList
			 * nodes = relation.getChildNodes(); for (int i = 0; i < nodes.getLength(); i++)
			 * {
			 * 
			 * if (nodes.item(i).getNodeName().equals("orig")) { Orig orig = new Orig();
			 * orig.setText(nodes.item(i).getTextContent()); a.setOrig(orig); } else if
			 * (nodes.item(i).getNodeName().equals("reg")) { Reg reg = new Reg();
			 * reg.setText(nodes.item(i).getTextContent()); a.setReg(reg); }
			 * 
			 * } apophthegms.add(a); }
			 */
			/*
			 * NodeList cis = (NodeList)
			 * xPath.compile("//seg[@type='contentItem']").evaluate(doc,
			 * XPathConstants.NODESET);
			 * 
			 * for (int y = 0; y < cis.getLength(); y++) { String id =
			 * cis.item(y).getAttributes().getNamedItem("xml:id").getNodeValue(); Apophthegm
			 * a = new Apophthegm(); a.setTextId(id); NodeList relations = (NodeList) xPath
			 * .compile("//seg[@type='contentItem' and @id='" + id + "']/choice")
			 * .evaluate(doc, XPathConstants.NODESET); for (int n = 0; n <
			 * relations.getLength(); n++) { Node relation = relations.item(n); NodeList
			 * nodes = relation.getChildNodes(); for (int i = 0; i < nodes.getLength(); i++)
			 * {
			 * 
			 * if (nodes.item(i).getNodeName().equals("orig")) { Orig orig = new Orig();
			 * orig.setText(nodes.item(i).getTextContent()); a.setOrig(orig); } else if
			 * (nodes.item(i).getNodeName().equals("reg")) { Reg reg = new Reg();
			 * reg.setText(nodes.item(i).getTextContent()); a.setReg(reg); }
			 * 
			 * } } apophthegms.add(a); }
			 */
		}
		return apophthegms;

	}

	private Apophthegm extractFromFile(String textId, File file) throws ParserConfigurationException,
			FileNotFoundException, SAXException, IOException, XPathExpressionException {
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
