package com.example.poems_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	@Autowired
	PoemService poemService;

	@CrossOrigin
	@PostMapping("/addPoemFromFile")
	public Iterable<Poem> addPoemsFromCsv(@RequestBody MultipartFile file)
	{
		
		if(FileFormatHelper.hasCSVFormat(file)) {
			try {
				List<Poem> poems = FileFormatHelper.csvToPoems(file.getInputStream());
				poemService.addItems(poems);
				return poems;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;		
	}
	
	@CrossOrigin
	@PostMapping("/addPoemsFromXML")
	public Iterable<Poem> addPoemFromXml(@RequestBody MultipartFile file)
	{
		
		if(FileFormatHelper.hasXMLFormat(file)) {
			try {
				List<Poem> poems = FileFormatHelper.xmlToPoems(file.getInputStream());
				poemService.addItems(poems);
				return poems;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;		
	}
	
	
}
