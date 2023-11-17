package com.example.poems_app.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.example.poems_app.Indexer;
import com.example.poems_app.xml.ContentItem;

@Service
public class ContentItemIndexer implements Indexer<ContentItem> {

	private SolrClient client = getSolrClient();
	
	@Override
	public void index(ContentItem item) {
        final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("relations", item.getRelations());
		doc.addField("text_id", item.getTextId());
		
		try {
     		client.add("poems", doc);
	    	client.commit("poems");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void indexAll(Iterable<ContentItem> items) {
		for(ContentItem item : items) {
			index(item);
		}
	}

	@Override
	public void removeItem(ContentItem item) throws SolrServerException, IOException {
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
