package com.example.poems_app.controllers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.services.ApophthegmTextExtractor;
import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.Apophthegm;
import com.example.poems_app.xml.ApophthegmText;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

@RestController
public class ApophthegmController {

	@Autowired
	private XmlPoemService xmlPoemService;
	
	@CrossOrigin
	@GetMapping("/apophthegms/{xmlid}")
	public List<ContentItem> getApophthegmsByXmlId(@PathVariable int xmlid) throws Exception {
		XmlPoem poem = xmlPoemService.getXmlPoemById(xmlid);
		List<ContentItem> cis = List.copyOf(poem.getContentItems());
		return cis;
	}
	
}
