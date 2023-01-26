package com.example.poems_app.services;

import java.io.IOException;
import java.util.Date;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.example.poems_app.Image;
import com.example.poems_app.Indexer;
import com.example.poems_app.Poem;

@Service
public class ImageIndexer implements Indexer<Image> { 

	SolrClient client = getSolrClient();
	
	@Override
	public void index(Image item) {
		final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("name", item.getName());
		doc.addField("description", item.getDescription());
		doc.addField("date",  item.getDate());
		doc.addField("filepath", item.getFilepath());
		
		try {
     		client.add("images", doc);
	    	client.commit("images");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void indexAll(Iterable<Image> items) {
		for(Image i : items) {
			index(i);
		}
	}
	
	protected SolrClient getSolrClient() {
		HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
		solr.setParser(new XMLResponseParser());
		
		return solr;
	}

	@Override
	public void removeItem(Image item) throws SolrServerException, IOException {
		client.deleteById(Integer.toString(item.getId()));
		client.commit();
		
	}
	
}
