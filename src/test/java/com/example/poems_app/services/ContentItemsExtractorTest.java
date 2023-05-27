package com.example.poems_app.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

@SpringBootTest
class ContentItemsExtractorTest {

	@Autowired
	private ContentItemsExtractor ciExtractor;
	
/**	@Test
	void shouldExtractContentItems() throws FileNotFoundException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
		List<ContentItem> contentItems = ciExtractor.getContentItems(new File("src/test/resources/test_poem.xml"));
		assertTrue(contentItems.size() == 1);
		assertTrue(contentItems.get(0).getRelations().get(0).equals("other_test_ci"));
	}*/

}
