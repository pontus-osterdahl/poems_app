package com.example.poems_app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.repositories.ChoiceRepository;
import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.ContentItemChoice;

@RestController
public class ContentItemChoiceController {

//	@Autowired
//	ChoiceRepository choiceRepository;
	
	@Autowired
	XmlPoemService xmlPoemService;
	
	@GetMapping("/choice/{id}")
	public ContentItemChoice getContentItemChoiceById(@PathVariable int id) throws Exception {
		return xmlPoemService.getChoiceById(id);
	}
}
