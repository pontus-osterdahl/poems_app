package com.example.poems_app.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

class XmlPoemServiceTest {

	
	
	
	@Test
	void shouldParseAndIndexPoem() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		XmlPoem poem = new XmlPoem();
		poem.setFilepath("C:\\Users\\pontu\\test_5contentItems.xml");
		
		XmlPoemService xmlPoemService = new XmlPoemService();
		List<ContentItem> contentItems = xmlPoemService.parsePoem(poem);
		System.out.println(contentItems.get(1).getChoice().getOrig().getText());
		assertTrue(contentItems.get(1).getChoice().getReg().getText().equals("blabla"));
		assertTrue(contentItems.size() == 5);
	}

}
