package com.example.poems_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.XmlPoem;

@RestController
public class ApophthegmController {

	@Autowired
	private XmlPoemService xmlPoemService;
	
	@CrossOrigin
	@GetMapping("/apophthegms/{xmlid}")
	public List<Seg> getApophthegmsByXmlId(@PathVariable int xmlid) throws Exception {
		List<Seg> cis = xmlPoemService.getContentItemsByXmlPoemId(xmlid);
		return cis;
	}
	
}
