package com.example.poems_app.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.solr.client.solrj.SolrServerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.XmlPoem;
import com.example.poems_app.xml.XmlPoemDTO;


@RestController
public class XmlPoemController {

	//private final ModelMapper mapper = new ModelMapper();
	@Autowired
	private XmlPoemService xmlPoemService;
	
	@Autowired
	ModelMapper mapper;
	
	@CrossOrigin
	@DeleteMapping("/xmlPoem/{id}")
	public void deleteXmlPoemById(@PathVariable int id) {
		xmlPoemService.deleteXmlPoemById(id);
	}
	
	@CrossOrigin
	@GetMapping("/xmlPoem/{id}")
	public XmlPoem getXmlPoemById(@PathVariable int id) throws Exception {
	    return xmlPoemService.getXmlPoemById(id);	
	}
	
	private XmlPoemDTO convertToXmlPoemDTO(XmlPoem xmlPoem) {
		return mapper.map(xmlPoem,XmlPoemDTO.class);
	}
	
	@CrossOrigin
	@PostMapping("/saveXmlPoem") 
	public XmlPoem addXmlPoem(@RequestPart XmlPoem xmlPoem, @RequestPart MultipartFile file) throws ParserConfigurationException, SAXException, IOException, SolrServerException, XPathExpressionException {
	    return xmlPoemService.savePoemWithFile(xmlPoem, file);	
	}	
	
	@CrossOrigin
	@GetMapping("/xmlPoemNames")
	public List<XmlPoemDTO> getXmlPoemNames() {
		List<XmlPoem> xmlPoems = StreamSupport.
				stream(xmlPoemService.findAllXmlPoems().spliterator(),
						false)
				.collect(Collectors.toList());
		
		return xmlPoems.stream()
				.map(this::convertToXmlPoemDTO)
				.collect(Collectors.toList());
	}

}
