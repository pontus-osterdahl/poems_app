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

	@Autowired
	private OrigExtractor origExtractor;
	
	/**
	 * Method returns content items
	 * @param doc Full document from which relations can be extracted.
	 * @param cis List of Nodes from which contentitems are to be extracted
	 * @return List of parsed content items
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 * @throws XPathExpressionException
	 */
	public List<Seg> getContentItems(Document doc, NodeList cis) throws ParserConfigurationException,
			FileNotFoundException, SAXException, IOException, XPathExpressionException {
		List<Seg> segs = new ArrayList<Seg>();
		XPath xPath = XPathFactory.newInstance().newXPath();

		for (int i = 0; i < cis.getLength(); i++) {
			Node current = cis.item(i);
			Seg item;
			if (current.getNodeType() == Node.ELEMENT_NODE) {
				if (current.getAttributes().getNamedItem("type").getTextContent().equals("contentItem")) {
					item = new ContentItem();
					List<String> relationsList = new ArrayList<String>();
					String textId = current.getAttributes().getNamedItem("xml:id").getNodeValue();
					NodeList relations = (NodeList) xPath.compile("//relation[@active=" + "'" + textId + "'" + "]")
							.evaluate(doc, XPathConstants.NODESET);
					for (int n = 0; n < relations.getLength(); n++) {
						Node relation = relations.item(n);
						String relationStr = relation.getAttributes().getNamedItem("passive").getNodeValue();
						if (relationStr != null) {
							relationsList.add(relationStr);
						}
					}
					item.setRelations(relationsList);
					item.setTextId(textId);
				} else {
					item = new DescriptiveItem();
				}

				Node node = cis.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;

					NodeList nodes = e.getElementsByTagName("orig");
					for (int o_i = 0; o_i < nodes.getLength() && o_i < 1; o_i++) {
						Orig orig = origExtractor.extractOrig(nodes.item(o_i));
						item.setOrig(orig);
					}

					nodes = e.getElementsByTagName("reg");
					for (int o_i = 0; o_i < nodes.getLength() && o_i < 1; o_i++) {
						Reg reg = origExtractor.extractReg(nodes.item(o_i));
						item.setReg(reg);
					}
				}
				segs.add(item);
			}
		}
		return segs;
	}
}
