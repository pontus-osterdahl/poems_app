package com.example.poems_app.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.example.poems_app.repositories.ContentItemRepository;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.DescriptiveItem;
import com.example.poems_app.xml.Orig;
import com.example.poems_app.xml.Reg;
import com.example.poems_app.xml.Seg;

@Service
public class ContentItemsExtractor {

	//@Autowired
	//private ContentItemRepository ciRepository;

	public List<Seg> getContentItems(Document doc, NodeList cis) throws ParserConfigurationException,
			FileNotFoundException, SAXException, IOException, XPathExpressionException {
		List<Seg> contentItems = new ArrayList<Seg>();
		XPath xPath = XPathFactory.newInstance().newXPath();

		for (int i = 0; i < cis.getLength(); i++) {
			Node current = cis.item(i);
			Seg item;
			if (current.getNodeType() == Node.ELEMENT_NODE) {
				if (current.getAttributes().getNamedItem("type").getTextContent().equals("contentItem")) {
					item = new ContentItem();
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
					item.setRelations(relationsList);
				} else {
					item = new DescriptiveItem();
				}

				Node node = cis.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;

					NodeList nodes = e.getElementsByTagName("orig");
					for (int o_i = 0; o_i < nodes.getLength() && o_i < 1; o_i++) {
						Orig orig = new Orig();
						orig.setText(nodes.item(o_i).getTextContent());
						item.setOrig(orig);
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
									if (correction != "" && origReading != "") {
										String addedValue = tmpCriticalApparatus != "" ? " | " : "";
										tmpCriticalApparatus += addedValue + correction + " : " + origReading;
									}
								} else if (withinOrigNode.getNodeName().equals("persName")) {
									if (withinOrigNode.getAttributes().getNamedItem("key") != null) {
										String persname = withinOrigNode.getAttributes().getNamedItem("key")
												.getTextContent();
										item.addPerson(persname);
									}
								}
							}
						}
						reg.setText(nodes.item(o_i).getTextContent());
						reg.setCriticalApparatus(tmpCriticalApparatus);
						item.setReg(reg);
					}
				}
				contentItems.add(item);
			}
		}
		return contentItems;
	}
}
