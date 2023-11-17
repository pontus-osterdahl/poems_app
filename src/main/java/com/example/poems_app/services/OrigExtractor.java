package com.example.poems_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.poems_app.Attribute;
import com.example.poems_app.xml.Add;
import com.example.poems_app.xml.Break;
import com.example.poems_app.xml.Graphic;
import com.example.poems_app.xml.HighLighted;
import com.example.poems_app.xml.LineBreak;
import com.example.poems_app.xml.Name;
import com.example.poems_app.xml.Orig;
import com.example.poems_app.xml.PageBreak;
import com.example.poems_app.xml.PersName;
import com.example.poems_app.xml.Reg;
import com.example.poems_app.xml.TextWrapper;
import com.example.poems_app.xml.Word;

@Service
public class OrigExtractor {

	public Orig extractOrig(Node origNode) {
		Orig orig = new Orig();
		List<Break> breaks = extractBreaks(origNode);
		orig.setBreaks(breaks);
		return orig;
	}

	private List<Break> extractBreaks(Node origNode) {
		NodeList nl = origNode.getChildNodes();
		List<Break> breaks = generateContent(nl);
		return breaks;
	}
	
	public Reg extractReg(Node regNode) {
		
		Reg reg = new Reg();
		List<Break> breaks = extractBreaks(regNode);
		reg.setBreaks(breaks);
		return reg;
	}

	private List<Attribute> generateAttributes(NamedNodeMap nmp) {

		List<Attribute> attrs = new ArrayList<Attribute>();

		if (Objects.nonNull(nmp)) {
			for (int i = 0; i < nmp.getLength(); i++) {

				Node attribute = nmp.item(0);
				String name = attribute.getNodeName();
				String value = attribute.getNodeValue();

				Attribute attr = new Attribute();
				attr.setName(name);
				attr.setValue(value);
				attrs.add(attr);
			}
		}

		return attrs;
	}

	private List<Break> generateContent(NodeList nl) {
		List<Break> breaks = new ArrayList();
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			String nodename = n.getNodeName();
			Break breakItem = null;
			if ("pb".equals(nodename) || "lb".equals(nodename)) {
				breakItem = nodename.equals("pb") ? new PageBreak() : new LineBreak();
			} else if ("hi".equals(nodename)) {
				breakItem = new HighLighted();
			} else if ("url".equals(nodename)) {
				breakItem = new Graphic();
			} else if ("add".equals(nodename)) {
				breakItem = new Add();
			} else if ("persName".equals(nodename)) {
				breakItem = new PersName();
			} else if ("name".equals(nodename)) {
				breakItem = new Name();
			}
			else if ("w".equals(nodename)) {
				breakItem = new Word();
				String line = n.getTextContent();
				breakItem.setText(line);
				breaks.add(breakItem);
				return breaks;
			}
			
			else if (n.getNodeType() == Node.TEXT_NODE) {
				breakItem = new TextWrapper();
				String line = n.getTextContent();
				breakItem.setText(line);
			}

			if (Objects.nonNull(breakItem)) {
				List<Attribute> attrs = generateAttributes(n.getAttributes());
				breakItem.setAttributes(attrs);
				NodeList addNl = n.getChildNodes();
				List<Break> content = generateContent(addNl);
				breakItem.setContent(content);
				breaks.add(breakItem);

			}
		}
		return breaks;
	}

}
