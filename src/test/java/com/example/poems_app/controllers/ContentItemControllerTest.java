package com.example.poems_app.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.XmlPoem;

@SpringBootTest
class ContentItemControllerTest {

	
	@MockBean
	private XmlPoemService xmlPoemService;
	@Autowired
	private ContentItemController contentItemController;

	@Test
	void testCorrectPoemReturnedByContentItemId() throws Exception {
		int choiceId = 5;
		String xmlPoemName = "xml_poem";
		XmlPoem xmlPoem = new XmlPoem();
		xmlPoem.setName(xmlPoemName);
		
		Mockito.when(xmlPoemService.getXmlPoemByContentItemId(choiceId)).thenReturn(xmlPoem);
		assertTrue(xmlPoemName.equals(contentItemController.getXmlPoemByContentItemId(choiceId).getName()));
		
	}
	
}
