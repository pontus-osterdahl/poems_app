package com.example.poems_app.services;

import java.util.Objects;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.springframework.stereotype.Service;

import com.example.poems_app.SearchRequest;
import com.example.poems_app.SearchType;

@Service
public class SolrQueryGenerator {

	public SolrClient getSolrClient() {
		return new ConcurrentUpdateSolrClient.Builder("http://localhost:8983/solr").build();
	}
	
	public SolrQuery getQuery(SearchRequest searchRequest) {
		if (Objects.nonNull(searchRequest.getLemma())) {
		    String lemma = searchRequest.getLemma();
		    String queryType = getStringFromSearchType(searchRequest);
		    SolrQuery query = new SolrQuery();
			query.setQuery(queryType + ":" + lemma);
			query.setStart(0); 
			return query;
		}
		throw new RuntimeException();	
	}
	
	private String getStringFromSearchType(SearchRequest searchRequest) {
		if (Objects.nonNull(searchRequest.getSearchType())) {
			switch(searchRequest.getSearchType()) { 
				case ALL:
					return "*";
				case TITLE:
					return "title";
				case WORD:
					return "word";
			}		
		}
		return "*";
	}
	
	
}
