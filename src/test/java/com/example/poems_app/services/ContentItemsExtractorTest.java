package com.example.poems_app.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

class ContentItemsExtractorTest {

	@Test
	void test() throws FileNotFoundException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
		ContentItemsExtractor xmlPoemService = new ContentItemsExtractor();
		List<ContentItem> contentItems = xmlPoemService.getContentItems(new File("C:\\Users\\pontu\\test_5contentItems.xml"));
		System.out.println(contentItems.get(1).getChoice().getOrig().getText());
		assertTrue(contentItems.size() == 5);
		assertTrue(contentItems.get(0).getRelations().get(0).equals("WA_Part01_A01_Antisthenes01_ci1"));
	}

}
