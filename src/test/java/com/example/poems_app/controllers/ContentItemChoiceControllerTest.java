package com.example.poems_app.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.ContentItemChoice;
import com.example.poems_app.xml.XmlPoem;


@SpringBootTest
class ContentItemChoiceControllerTest {

	@MockBean
	private XmlPoemService xmlPoemService;
	
	@Autowired
	private ContentItemChoiceController choiceController;
	
	@Test
	void testCorrectChoiceReturnedById() throws Exception {
		int choiceId = 5;
	
		ContentItemChoice cic = new ContentItemChoice();
		cic.setId(choiceId);
		
		Mockito.when(xmlPoemService.getChoiceById(choiceId)).thenReturn(cic);
		assertTrue(choiceId == choiceController.getContentItemChoiceById(choiceId).getId());
	}
	

}
