package com.example.poems_app.services;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

public class SolrClientProvider {

	public static SolrClient getSolrClient() {
		HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
		solr.setParser(new XMLResponseParser());
		
		return solr;
	}
	
}
