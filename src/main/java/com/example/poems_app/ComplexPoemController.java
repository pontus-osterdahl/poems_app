package com.example.poems_app;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ComplexPoemController {
//	@Autowired
//	private ComplexPoemRepository complexPoemRepository;
	
	
	@CrossOrigin
	@PostMapping("/addComplexPoemFromXML")
	public ComplexPoemOld addPoemFromXml(@RequestBody MultipartFile file)
	{
		if(FileFormatHelper.hasXMLFormat(file)) {
			try {
				ComplexPoemOld poem = FileFormatHelper.xmlToComplexPoem(file.getInputStream());
				//complexPoemRepository.save(poem);
				ComplexPoem complexPoem = poem.getText();
				Word w = (Word) complexPoem.getLemma().get(0);
				System.out.println(w.getLanguage());
				return poem;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;		
	}
	
	@CrossOrigin
	@PostMapping("/addTeiRepresentation")
	public Edition addTeiRepresentationFromXml(@RequestBody MultipartFile file)
	{
		if(FileFormatHelper.hasXMLFormat(file)) {
			try {
				TeiRepresentation poem = FileFormatHelper.xmlToTeiRepresentation(file.getInputStream());
				//complexPoemRepository.save(poem);
				return EditionGenerator.generateEdition(poem);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;		
	}
}

