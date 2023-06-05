package com.example.poems_app.controllers;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.example.poems_app.FileFormatHelper;
import com.example.poems_app.FileStorageService;
import com.example.poems_app.Poem;
import com.example.poems_app.services.PoemService;
import com.example.poems_app.services.XmlPoemService;
import com.example.poems_app.xml.XmlPoem;

@RestController
public class FileUploadController {

	@Autowired
	PoemService poemService;
	
	@Autowired
	XmlPoemService xmlPoemService;

	@CrossOrigin
	@PostMapping("/addPoemFromFile")
	public Iterable<Poem> addPoemsFromCsv(@RequestBody MultipartFile file) {
		if (FileFormatHelper.hasCSVFormat(file)) {
			try {
				List<Poem> poems = FileFormatHelper.csvToPoems(file.getInputStream());
				poemService.addItems(poems);
				return poems;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@CrossOrigin
	@PostMapping("/addPoemsFromXML")
	public Iterable<Poem> addPoemFromXml(@RequestBody MultipartFile file) {
		if (FileFormatHelper.hasXMLFormat(file)) {
			try {
				List<Poem> poems = FileFormatHelper.xmlToPoems(file.getInputStream());
				poemService.addItems(poems);
				return poems;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
