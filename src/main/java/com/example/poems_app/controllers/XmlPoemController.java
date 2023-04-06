package com.example.poems_app.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.XmlPoem;
import com.example.poems_app.xml.XmlPoemDTO;

//import lombok.AllArgsConstructor;

//@AllArgsConstructor
@RestController
public class XmlPoemController {

	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	private XmlPoemService xmlPoemService;
	
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
