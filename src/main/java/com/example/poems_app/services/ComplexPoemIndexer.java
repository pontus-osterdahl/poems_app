package com.example.poems_app.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.example.poems_app.*;

@Service
public class ComplexPoemIndexer implements Indexer<ComplexPoemOld>{

	private final SolrClient client = SolrClientProvider.getSolrClient();

	@Override
	public void index(ComplexPoemOld item) {
	final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("title", item.getTitle());
		doc.addField("text", item.getText().toString());		
		try {
     		client.add("complexpoems", doc);
	    	client.commit("complexpoems");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public void indexAll(Iterable<ComplexPoemOld> items) {
		for(ComplexPoemOld i: items) {
			index(i);
		}
		
	}

	@Override
	public void removeItem(ComplexPoemOld item) throws SolrServerException, IOException {
		client.deleteById(Integer.toString(item.getId()));
		
	}
}
