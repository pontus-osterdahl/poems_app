package com.example.poems_app.services;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.example.poems_app.SearchRequest;
import com.example.poems_app.SearchType;
import com.example.poems_app.xml.ContentItem;

public class ContentItemSearchService implements SearchService<ContentItem>{

	@Override
	public List<ContentItem> search(String queryItem) throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentItem> getAll() throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SearchType[] getSearchTypes() {
		return new SearchType[] {SearchType.ALL, SearchType.TITLE, SearchType.WORD};
	}

	@Override
	public List<ContentItem> search(SearchRequest searchRequest) throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
