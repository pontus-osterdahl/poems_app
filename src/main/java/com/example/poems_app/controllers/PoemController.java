package com.example.poems_app.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.BibItem;
import com.example.poems_app.BookWriter;
import com.example.poems_app.Poem;
import com.example.poems_app.services.BibItemService;
import com.example.poems_app.services.PoemService;

@RestController
public class PoemController {
	
	@Autowired
	PoemService poemService;
	
	@Autowired
	BibItemService bibItemService;
	
	@CrossOrigin
	@GetMapping("/poems/getPoem/{id}")
	public Optional<Poem> getPoem(@PathVariable int id)
	{
		return poemService.getById(id);
	}
	
	@CrossOrigin
	@GetMapping("/poems/getbyword/{word}")
	public Iterable<Poem> getPoemsbyWord(@PathVariable String word){
		return poemService.getByWord(word);
	}
	
	@CrossOrigin
	@GetMapping("/poems/poems")
	public Iterable<Poem> getPoems()
	{
		return poemService.getAll();
	}
	
	@CrossOrigin
	@PostMapping("/poems/addPoem")
	public Poem addPoem(@RequestBody Poem poem)
	{			
		return poemService.add(poem);
	}
	
	
	@CrossOrigin
	@PutMapping("/poems/updatePoem/{id}")
	public Poem addPoem(@PathVariable int id, @RequestBody Poem poem)
	{			
		if(id >= 0) {
    		poem.setId(id);
    		return poemService.update(poem);
		}
		
		return null;
	}
	
	
	@CrossOrigin
	@PutMapping("/poems/reindex")
	public void reIndexPoems() throws SolrServerException, IOException{
		poemService.reIndex();
	}

	@GetMapping("/poems/{id}/getXml") 
	public void downloadPoemFileXml(@PathVariable int id, HttpServletResponse response) {
		Optional<Poem> p = poemService.getById(id);
		p.ifPresent(poem -> {
			try {
				writeStringToXMLDownload(response, poem, "POEM_" + id + ".xml");
			} catch (IOException | JAXBException e) {
				e.printStackTrace();
			}
		});
	}
	
	
	@CrossOrigin
	@PostMapping("/poems/{id}/bibitem/{bibItemId}")
	public ResponseEntity<Poem> addBibItemToPoem(@PathVariable int id, @PathVariable int bibItemId) throws Exception{
		return new ResponseEntity<>(poemService.addBibItemToPoem(id, bibItemId),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/poems/{id}/getFile")
	public void downloadPoemFile(@PathVariable int id, HttpServletResponse response) throws IOException {
		Optional<Poem> p = poemService.getById(id);
		p.ifPresent(poem -> {
			try {
				writeStringToDownload(response, new BookWriter().writePoem(poem), "POEM_" + id + ".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@CrossOrigin
	@GetMapping("/poems/getFullFile")
	public void download(HttpServletResponse response) throws IOException {
		
		String fileContent = new BookWriter().writePoems(poemService.getAll());
		writeStringToDownload(response, fileContent, "ALL_POEMS.txt");
	}
	
    public void writeStringToXMLDownload(HttpServletResponse response, Poem poem, String filename) throws IOException, JAXBException {
		
		response.addHeader("Content-disposition", "attachment;filename=" + filename);
		response.setContentType("txt/plain");
		
		JAXBContext context = JAXBContext.newInstance(Poem.class);
	    Marshaller mar= context.createMarshaller();
	    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    
	    
//		InputStream inStream = new ByteArrayInputStream(fileContent.getBytes("UTF-8")); 
		
		OutputStream outStream = response.getOutputStream();
		mar.marshal(poem, outStream);

		outStream.flush();
		outStream.close();
	}
	
	public void writeStringToDownload(HttpServletResponse response, String fileContent, String filename) throws IOException {
		
		response.addHeader("Content-disposition", "attachment;filename=" + filename);
		response.setContentType("txt/plain");
		
		InputStream inStream = new ByteArrayInputStream(fileContent.getBytes("UTF-8")); 
		
		OutputStream outStream = response.getOutputStream();
		
		byte[] buf = new byte[4096];
		int len = -1;

		while ((len = inStream.read(buf)) != -1) {
			outStream.write(buf, 0, len);
		}

		outStream.flush();
		outStream.close();
	}
}
