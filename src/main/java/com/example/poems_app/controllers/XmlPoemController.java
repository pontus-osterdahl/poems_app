package com.example.poems_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.XmlPoem;

@RestController
public class XmlPoemController {

	@Autowired
	private XmlPoemService xmlPoemService;
	
	@CrossOrigin
	@GetMapping("/xmlPoem/{id}")
	public XmlPoem getXmlPoemById(@PathVariable int id) throws Exception {
	    return xmlPoemService.getXmlPoemById(id);	
	}
}
