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
import org.apache.solr.common.SolrException;
import org.springframework.stereotype.Service;

import com.example.poems_app.Poem;
import com.example.poems_app.SearchRequest;
import com.example.poems_app.SearchType;

public interface SearchService<T> {
    public List<T> search(String queryItem) throws SolrServerException, IOException;
    public List<T> getAll() throws SolrServerException, IOException;
    public SearchType[] getSearchTypes();
    public List<T> search(SearchRequest searchRequest) throws SolrServerException, IOException;
}


