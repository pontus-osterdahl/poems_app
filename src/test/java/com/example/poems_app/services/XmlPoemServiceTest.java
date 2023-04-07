package com.example.poems_app.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import com.example.poems_app.repositories.XmlPoemRepository;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

@SpringBootTest
class XmlPoemServiceTest {

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
	}

}
