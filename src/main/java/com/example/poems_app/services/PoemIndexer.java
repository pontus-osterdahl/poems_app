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
public class PoemIndexer implements Indexer<Poem> { 
	
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
			client.deleteByQuery("poems", "id:" + item.getId());
			client.commit("poems");
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeById(int id)  {
		try {
			System.out.println(client.deleteByQuery("poems", "id:" + id));
			client.commit("poems");
		} catch (SolrServerException | IOException e) {
			System.out.println("Delete not working");
		}
	}
	
	protected SolrClient getSolrClient() {
		HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
		//solr.setParser(new XMLResponseParser());
		
		return solr;
	}
}