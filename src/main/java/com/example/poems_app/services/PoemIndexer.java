package com.example.poems_app.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.example.poems_app.Indexer;
import com.example.poems_app.Poem;

@Service
class PoemIndexer implements Indexer<Poem> { 
	
	protected SolrClient client;
	public PoemIndexer() {
		client = getSolrClient();
	}
	
	public void index(Poem item){
		
		final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("title", item.getTitle());
		doc.addField("text", item.getText());
		
		try {
     		client.add("poems", doc);
	    	client.commit("poems");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void indexAll(Iterable<Poem> items) {
		for(Poem poem : items) {
			index(poem);
		}
	}
	
	public void clearIndex() throws SolrServerException, IOException {
		client.deleteByQuery("poems", "*:*");
		client.commit("poems");
	}
	
	public void removeItem(Poem item)  {
		try {
			client.deleteById(Integer.toString(item.getId()));
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}
	
	protected SolrClient getSolrClient() {
		HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
		solr.setParser(new XMLResponseParser());
		
		return solr;
	}
}