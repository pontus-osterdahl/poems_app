package com.example.poems_app.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.poems_app.Indexer;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.XmlPoem;

public class SegIndexer implements Indexer<Seg> {

    protected SolrClient client;
	
	public SegIndexer() {
		client = getSolrClient();
	}
	
	@Autowired
	SolrDocumentCreator docCreator;
	
	@Override
	public void index(Seg seg) {
		
	    final SolrInputDocument doc = docCreator.getSolrInputDoument(seg);
     	try {
     		client.add("poems", doc);
	        client.commit("poems");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void indexAll(Iterable<Seg> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(Seg item) throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearIndex() throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected SolrClient getSolrClient() {
		HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
		
		return solr;
	}

}
