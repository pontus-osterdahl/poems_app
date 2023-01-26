package com.example.poems_app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrException;
import org.springframework.stereotype.Service;

public interface SearchService<T> {
    public List<T> search(String queryItem) throws SolrServerException, IOException;
    public List<T> getAll() throws SolrServerException, IOException;
}

class PoemSearchService implements SearchService<Poem>{
	@Override
	public List<Poem> search(String queryItem) throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.setQuery("text:" + queryItem);
		query.setStart(0);
		
		SolrClient solrClient = getSolrClient();
		
		QueryResponse response = solrClient.query("poems", query);
		SolrDocumentList docList = response.getResults();
		
		List<Poem> poems = new ArrayList<Poem>();
		
		for(SolrDocument doc : docList) {
			Poem poem = mapDocToPoem(doc);
			poems.add(poem);
		}		
		return poems;
	}
	
	
	private Poem mapDocToPoem(SolrDocument doc) {
		Poem poem = new Poem();
		poem.setId(Integer.valueOf((String) doc.getFirstValue("id")));
		poem.setTitle((String)doc.getFirstValue("title"));
		poem.setText((String)doc.getFirstValue("text"));
		return poem;
	}
	
	@Override
	public List<Poem> getAll() throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		
		SolrClient solrClient = getSolrClient();
		
		QueryResponse response = solrClient.query("poems", query);
		SolrDocumentList docList = response.getResults();
		
		List<Poem> poems = new ArrayList<Poem>();
		
		for(SolrDocument doc : docList) {
			Poem poem = mapDocToPoem(doc);
			poems.add(poem);
		}		
		return poems;
		
	}
	
	protected SolrClient getSolrClient() {
		return new ConcurrentUpdateSolrClient.Builder("http://localhost:8983/solr").build();
	}
	
}
