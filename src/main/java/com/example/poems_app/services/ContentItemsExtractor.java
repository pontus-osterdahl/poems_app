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
import com.example.poems_app.repositories.ChoiceRepository;
import com.example.poems_app.repositories.ContentItemRepository;
import com.example.poems_app.repositories.OrigRepository;
import com.example.poems_app.repositories.RegRepository;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.ContentItemChoice;
import com.example.poems_app.xml.Orig;
import com.example.poems_app.xml.Reg;

@Service
public class ContentItemsExtractor {

	@Autowired
	private OrigRepository origRepository;

	@Autowired
	private RegRepository regRepository;

	@Autowired
	private ContentItemRepository ciRepository;

	@Autowired
	private ChoiceRepository choiceRepository;

	public List<ContentItem> getContentItems(File file) throws ParserConfigurationException, FileNotFoundException,
			SAXException, IOException, XPathExpressionException {
		List<ContentItem> contentItems = new ArrayList<ContentItem>();
		ContentItemChoice choice = null;
		if (FileFormatHelper.hasXMLFormat(file)) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new BufferedInputStream(new FileInputStream(file)));
			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList nodeList = doc.getElementsByTagName("seg");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node current = nodeList.item(i);
				if (current.getNodeType() == Node.ELEMENT_NODE) {
					if (current.getAttributes().getNamedItem("type").getTextContent().equals("contentItem")) {
						List<String> relationsList = new ArrayList<String>();
						String id = current.getAttributes().getNamedItem("xml:id").getNodeValue();
						NodeList relations = (NodeList) xPath.compile("//relation[@active=" + "'" + id + "'" + "]")
								.evaluate(doc, XPathConstants.NODESET);
						for (int n = 0; n < relations.getLength(); n++) {
							Node relation = relations.item(n);
							String relationStr = relation.getAttributes().getNamedItem("passive").getNodeValue();
							if (relationStr != null) {
								relationsList.add(relationStr);
							}
						}

						NodeList choiceList = current.getChildNodes();

						for (int y = 0; y < choiceList.getLength(); y++) {
							Node choiceNode = choiceList.item(y);
							if (choiceNode != null && choiceNode.getNodeType() == Node.ELEMENT_NODE) {
								if (choiceNode.getNodeName().equals("choice")) {
									choice = new ContentItemChoice();
									Orig orig = null;
									Reg reg = null;
									NodeList edChoiceList = choiceNode.getChildNodes();
									for (int x = 0; x < edChoiceList.getLength(); x++) {

										Node edChoiceNode = edChoiceList.item(x);
										if (edChoiceNode.getNodeName().equals("orig")) {
											orig = new Orig();
											NodeList withinOrig = edChoiceNode.getChildNodes();
											/**for (int u = 0; u < withinOrig.getLength(); u++) {
												Node withinOrigNode = withinOrig.item(u);
												if (withinOrigNode.getNodeType() == Node.ELEMENT_NODE) {
													if (withinOrigNode.getNodeName().equals("expan")) {
														String tmpString = withinOrigNode.getTextContent();
														if (tmpString != null && tmpString != "") {
															withinOrigNode.setTextContent("(" + tmpString + ")");
															System.out.println("(" + tmpString + ")");
														}
													}
												}

											}
											System.out.println(edChoiceNode.getTextContent());*/
											orig.setText(edChoiceNode.getTextContent());
										}
										if (edChoiceNode.getNodeName().equals("reg")) {
											reg = new Reg();
											String tmpCriticalApparatus = "";
											NodeList withinOrig = edChoiceNode.getChildNodes();
											for (int u = 0; u < withinOrig.getLength(); u++) {
												Node withinOrigNode = withinOrig.item(u);
												if (withinOrigNode.getNodeType() == Node.ELEMENT_NODE) {
													if (withinOrigNode.getNodeName().equals("choice")) {
														String origReading = "";
														String correction = "";
														NodeList withinInnerChoiceList = withinOrigNode.getChildNodes();
														for (int a = 0; a < withinInnerChoiceList.getLength(); a++) {
															Node aNode = withinInnerChoiceList.item(a);
															if (aNode.getNodeType() == Node.ELEMENT_NODE
																	&& aNode.getNodeName().equals("sic")) {
																origReading = aNode.getTextContent();
																aNode.setTextContent("");
															} else if (aNode.getNodeType() == Node.ELEMENT_NODE
																	&& aNode.getNodeName().equals("corr")) {
																correction = aNode.getTextContent();
															}
														}
														System.out.println(
																"CritApp: " + correction + " : " + origReading);
														if (correction != "" && origReading != "") {
															String addedValue = tmpCriticalApparatus != "" ? " | " : ""; 
															tmpCriticalApparatus += addedValue + correction + " : " + origReading;
														}
													}
												}

											}
											System.out.println(edChoiceNode.getTextContent());
											reg.setText(edChoiceNode.getTextContent());
											System.out.println(tmpCriticalApparatus);
											reg.setCriticalApparatus(tmpCriticalApparatus);
										}
									}
									if (orig != null) {
										choice.setOrig(origRepository.save(orig));
									}
									if (reg != null) {
										choice.setReg(regRepository.save(reg));
									}
								}
							}
						}
						if (id != null) {
							ContentItem item = new ContentItem();
							item.setTextId(id);
							item.setRelations(relationsList);
							ContentItem permCi = ciRepository.save(item);
							if (choice != null) {
								choice.setContentitem(permCi);
								item.setChoice(choiceRepository.save(choice));
							}
							contentItems.add(item);
						}
					}
				}
			}
		}
		return contentItems;
	}

}
