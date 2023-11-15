package com.example.poems_app.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import com.example.poems_app.repositories.XmlPoemRepository;
import com.example.poems_app.xml.AuthorSection;
import com.example.poems_app.xml.Body;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Letter;
import com.example.poems_app.xml.Part;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.Text;
import com.example.poems_app.xml.XmlPoem;

@SpringBootTest
class XmlPoemServiceTest {
/**
	
	
	@Autowired
	XmlPoemService service;

	@Test
	void shouldGetXmlPoemById() throws Exception {
		XmlPoem xmlPoem = service.saveXmlPoem(new XmlPoem());

		int id = xmlPoem.getId();
		XmlPoem fetchedPoem = service.getXmlPoemById(id);
		assertThat(fetchedPoem.equals(xmlPoem));

		service.deleteXmlPoemById(id);

	}
	
	@Test
	void shouldGetContentItemByXmlPoemId() throws Exception {
	
		XmlPoem xmlPoem = new XmlPoem();
		xmlPoem.setFilepath("TEST PATH");
		xmlPoem.setId(1);
		xmlPoem.setName("TEST POEM");
		Text text = new Text();
		TextGroup textGroup = new TextGroup();
		InnerText innerText = new InnerText();
		Body body = new Body();
		List<Part> parts = new ArrayList();
		Part part = new Part();
		List<Letter> letters = new ArrayList();
		Letter letter = new Letter();
		AuthorSection author = new AuthorSection();
		List<AuthorSection> authors = new ArrayList();
		authors.add(author);
		List<Seg> segs = new ArrayList();
		Seg seg = new ContentItem();
		seg.setId(9999);
		seg.setTextId("hallo");
		Set<String> persons = new HashSet();
		Set<String> placenames = new HashSet();
		seg.setPersons(persons);
		seg.setPlacenames(placenames);
		author.setSegments(segs);
		letter.setAuthors(authors);
		letters.add(letter);
		part.setLetters(letters);
		parts.add(part);
		body.setParts(parts);
		innerText.setBody(body);
		textGroup.setInnerText(innerText);
		text.setGroup(textGroup);
		xmlPoem.setText(text);
		
		
		int id = xmlPoem.getId();
		ContentItem ci1 = new ContentItem();
		ci1.setTextId("ci1");
		
		ContentItem ci2 = new ContentItem();
		ci2.setTextId("ci2");
		
		List<ContentItem> cis = Arrays.asList(ci1,ci2);

		
		xmlPoem = service.saveXmlPoem(xmlPoem);
		
		List<Seg> fetchedCis = service.getContentItemsByXmlPoemId(id);
		
		assertThat(fetchedCis.get(0).getTextId().equals("ci1"));

		service.deleteXmlPoemById(id);

	}

	@Test
	void shouldDeleteXmlPoemById() {
		
		XmlPoem xmlPoem = service.saveXmlPoem(new XmlPoem());

		int id = xmlPoem.getId();
		service.deleteXmlPoemById(id);

		assertThrows(Exception.class, () -> {
			service.getXmlPoemById(id);
		});
	}

	@Test
	void shouldParseAndIndexPoem() throws FileNotFoundException, ParserConfigurationException, SAXException,
			IOException, XPathExpressionException {
		XmlPoem poem = new XmlPoem();
		poem.setFilepath("C:\\Users\\pontu\\test_5contentItems.xml");

		XmlPoemService xmlPoemService = new XmlPoemService();
		List<ContentItem> contentItems = xmlPoemService.parsePoem(poem);
		assertTrue(contentItems.size() == 5);
		assertTrue(contentItems.get(0).getRelations().get(0).equals("WA_Part01_A01_Antisthenes01_ci1"));
	}*/

}
