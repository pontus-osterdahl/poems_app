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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.poems_app.xml.AuthorSection;
import com.example.poems_app.xml.Body;
import com.example.poems_app.xml.DocTitle;
import com.example.poems_app.xml.Front;
import com.example.poems_app.xml.TextGroup;
import com.example.poems_app.xml.InnerText;
import com.example.poems_app.xml.Letter;
import com.example.poems_app.xml.Part;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.TeiHeader;
import com.example.poems_app.xml.Text;
import com.example.poems_app.xml.TitlePage;
import com.example.poems_app.xml.TitlePart;

@Service
public class TextExtractor {

	@Autowired
	ContentItemsExtractor cisExtractor;

	private InnerText getInnerText(Document doc, NodeList innerTexts) throws FileNotFoundException,
			XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		InnerText innerText = new InnerText();
		for (int i = 0; i < innerTexts.getLength(); i++) {
			if (innerTexts.item(i).getNodeName().equals("text")) {
				String xmlId = innerTexts.item(i).getAttributes().getNamedItem("xml:id").getNodeValue();
				innerText.setXmlId(xmlId);
				NodeList innerTextChildren = innerTexts.item(i).getChildNodes();
				for (int y = 0; y < innerTextChildren.getLength(); y++) {
                    if (innerTextChildren.item(y).getNodeName().equals("front")) {
    					Front front = getFront(innerTextChildren.item(y).getChildNodes());
    					innerText.setFront(front);
                    }
                    else if (innerTextChildren.item(y).getNodeName().equals("body")) {
    					Body body = getBody(doc, innerTextChildren.item(y).getChildNodes());
    					innerText.setBody(body);	
                    }
				}
			}
		}
		return innerText;
	}

	public Text getText(Document doc) throws FileNotFoundException, XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "//TEI/text";

		NodeList nL = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		Text text = new Text();

		System.out.println("Length: " + nL.getLength());

		for (int y = 0; y < nL.getLength(); y++) {
			System.out.println("NODEVALUE " + nL.item(y).getNodeName());
			if ("text".equals(nL.item(y).getNodeName())) {

				NodeList nodeList = nL.item(y).getChildNodes();

				for (int i = 0; i < nodeList.getLength(); i++) {
					Node item = nodeList.item(i);
					System.out.println(item.getNodeName());

					if ("group".equals(item.getNodeName())) {
						System.out.println("GOT TO GROUP");
						TextGroup group = new TextGroup();
						InnerText it = getInnerText(doc, item.getChildNodes());
						group.setInnerText(it);
						text.setGroup(group);
					}
				}
			}
		}
		return text;

	}

	public Front getFront(NodeList frontList) {
		Front front = new Front();
		for (int i = 0; i < frontList.getLength(); i++) {
			Node item = frontList.item(i);
			if (item.getNodeName().equals("cover")) {
				TitlePage titlePage = new TitlePage();
				String type = item.getAttributes().getNamedItem("type").getNodeValue();
				titlePage.setType(type);
				NodeList docTitleList = item.getChildNodes();
				for (int y = 0; y < docTitleList.getLength(); y++) {
					if (docTitleList.item(i).getNodeName().equals("docTitle")) {
						DocTitle docTitle = getDocTitle(docTitleList.item(i).getChildNodes());
						titlePage.setDocTitle(docTitle);
					}
				}
				front.setTitlePage(titlePage);
			}
		}
		return front;
	}

	public Body getBody(Document doc, NodeList bodyList) throws FileNotFoundException, XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		Body body = new Body();
		List<Part> parts = new ArrayList<Part>();
		for (int i = 0; i < bodyList.getLength(); i++) {
			if (bodyList.item(i).getNodeName().equals("div")) {
				Part part = new Part();
				String xmlId = bodyList.item(i).getAttributes().getNamedItem("xml:id").getNodeValue();
				part.setXmlId(xmlId);
				List<Letter> letters = getLetters(doc, bodyList.item(i).getChildNodes());
				part.setLetters(letters);
				parts.add(part);
			}
		}
		body.setParts(parts);
		return body;
	}

	public List<Letter> getLetters(Document doc, NodeList letterList) throws FileNotFoundException,
			XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		List<Letter> letters = new ArrayList<Letter>();
		for (int i = 0; i < letterList.getLength(); i++) {
			if (letterList.item(i).getNodeName().equals("div")) {
				Letter letter = new Letter();
				String xmlId = letterList.item(i).getAttributes().getNamedItem("xml:id").getNodeValue();
				letter.setXmlId(xmlId);
				List<AuthorSection> authors = getAuthorSections(doc, letterList.item(i).getChildNodes());
				letter.setAuthors(authors);
				letters.add(letter);
			}
		}
		return letters;
	}

	public List<AuthorSection> getAuthorSections(Document doc, NodeList authorSectionList) throws FileNotFoundException,
			XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		List<AuthorSection> authors = new ArrayList<AuthorSection>();
		for (int i = 0; i < authorSectionList.getLength(); i++) {
			Node n = authorSectionList.item(i);
			if (n.getNodeName().equals("ab")) {
				AuthorSection author = new AuthorSection();
				String xmlId = n.getAttributes().getNamedItem("xml:id").getNodeValue();
				author.setAuthorId(xmlId);
				List<Seg> segs = cisExtractor.getContentItems(doc, n.getChildNodes());
				author.setSegments(segs);
				authors.add(author);
			}
		}
		return authors;
	}

	public DocTitle getDocTitle(NodeList docTitleList) {
		DocTitle docTitle = new DocTitle();
		for (int i = 0; i < docTitleList.getLength(); i++) {
			Node item = docTitleList.item(i);
			if (item.getNodeName().equals("titlePart")) {
				TitlePart titlePart = new TitlePart();
				String title = item.getTextContent();
				titlePart.setTitle(title);
			}
		}
		return docTitle;
	}
}
