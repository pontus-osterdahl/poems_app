package com.example.poems_app.services;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.poems_app.xml.Group;
import com.example.poems_app.xml.InnerText;
import com.example.poems_app.xml.TeiHeader;
import com.example.poems_app.xml.Text;

@Service
public class TextExtractor {

	private InnerText getInnerText(NodeList innerTexts) {
		for (int i = 0; i < innerTexts.getLength(); i++) {
			if (innerTexts.item(i).getLocalName().equals("text")) {
				String xmlId = innerTexts.item(i).getAttributes().getNamedItem("xml:id").getNodeValue();
				InnerText innerText = new InnerText();
				innerText.setXmlId(xmlId);
			}
		}
	}
	
	public Text getText(Document doc, NodeList cis) {
	
		Text text = new Text();
		for(int i = 0; i < cis.getLength(); i++) {
			Node item = cis.item(i);
			if (item.getLocalName().equals("group")) {
				Group group = new Group();
				
				
				
			}
		}
		return new Text();
		
	}
}
