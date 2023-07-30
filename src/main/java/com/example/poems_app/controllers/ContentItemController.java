package com.example.poems_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.Apophthegm;
import com.example.poems_app.xml.ApophthegmText;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.XmlPoem;

@RestController
public class ContentItemController {
	
	@Autowired
	private XmlPoemService xmlPoemService;
	
	@CrossOrigin
    @GetMapping("/contentItems/xmlPoemId/{id}")
	public XmlPoem getXmlPoemByContentItemId(@PathVariable int id) throws Exception {
    	return xmlPoemService.getXmlPoemByContentItemId(id);
    }
	
	@CrossOrigin
	@GetMapping("/contentItems/byXmlPoemId/{id}")
	public List<Seg> getContentItemsByXmlPoemId(@PathVariable int id) throws Exception {
		return xmlPoemService.getContentItemsByXmlPoemId(id);
    	
    }
    
	@CrossOrigin
    @GetMapping("/contentItems/textId/{textId}")
    public ContentItem getContentItemByTextId(@PathVariable String textId) throws Exception {
    	return xmlPoemService.getContentItemByTextId(textId);
    }
    
	@CrossOrigin
    @GetMapping("/contentItems")
    public Iterable<ContentItem> getContentItems() {
    	return xmlPoemService.getContentItems();
    }
	
/**	@CrossOrigin
    @GetMapping("/contentItems")
    public Iterable<ContentItem> getContentItems() {
    	return xmlPoemService.getContentItems();
    }*/
}