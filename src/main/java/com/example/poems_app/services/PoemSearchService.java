package com.example.poems_app.services;

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
import org.springframework.stereotype.Service;

import com.example.poems_app.Poem;
import com.example.poems_app.SearchRequest;
import com.example.poems_app.SearchType;

@Service
public class PoemSearchService implements SearchService<Poem>{
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
	
	public Poem getByid(int id) {
		SolrQuery query = new SolrQuery();
		query.setQuery("id:" + id);
		query.setStart(0);
		
		SolrClient solrClient = getSolrClient();
		SolrDocumentList docList = null;
		
		
		QueryResponse response;
		try {
			response = solrClient.query("poems", query);
			docList = response.getResults();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List<Poem> poems = new ArrayList<Poem>();
		
		for(SolrDocument doc : docList) {
			Poem poem = mapDocToPoem(doc);
			poems.add(poem);
		}		
		return poems.size() > 0 ? poems.get(0) : null;
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

	@Override
	public SearchType[] getSearchTypes() {
		return new SearchType[] {SearchType.ALL, SearchType.TITLE, SearchType.WORD};
	}

	@Override
	public List<Poem> search(SearchRequest searchRequest) throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
