package com.example.poems_app.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.poems_app.SearchRequest;
import com.example.poems_app.SearchType;
import com.example.poems_app.services.XmlPoemSearchService;
import com.example.poems_app.xml.XmlPoem;

@RestController
public class SearchController {
	
	@Autowired
	XmlPoemSearchService xmlPoemSearchService;
	
	@CrossOrigin
	@GetMapping("/getSearchTypes")
	public SearchType[] getSearchTypes() {
		return SearchType.values();
	}
	
	@CrossOrigin
	@GetMapping("/getXmlPoemSearchTypes")
	public SearchType[] getXmlPoemSearchTypes() {
		return xmlPoemSearchService.getSearchTypes(); 
	}
	
	/**
	 * Returns a list of XmlPoems found by the searchrequest.
	 * @param searchType The type of search.
	 * @param lemma The actual search term
	 * @return The list of found XmlPoems
	 * @throws SolrServerException Thrown if Solr could not be correctly connected to
	 * @throws IOExceptions
	 */
	@CrossOrigin
	@GetMapping("/getXmlPoemByWord")
	public List<XmlPoem> searchBySearchRequest(@RequestParam SearchType searchType, @RequestParam String lemma) throws SolrServerException, IOException {
		return xmlPoemSearchService.search(new SearchRequest(lemma,searchType,""));
	}
}
