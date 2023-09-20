package com.example.poems_app.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.poems_app.SearchType;
import com.example.poems_app.services.XmlPoemSearchService;
import com.example.poems_app.services.XmlPoemService;

@ExtendWith(MockitoExtension.class)
class XmlPoemControllerTest {
	
	@InjectMocks
	private SearchController xmlPoemController;
	
	@Mock
	private XmlPoemSearchService xmlPoemSearchService;
	
	
	@Test
	void shouldGetSearchTypes() {
		when(xmlPoemSearchService.getSearchTypes()).thenReturn(new SearchType[] {SearchType.ALL, SearchType.TITLE, SearchType.WORD} );
		
		Assertions.assertThat(xmlPoemController.getXmlPoemSearchTypes()).hasSize(3);
	}
}
