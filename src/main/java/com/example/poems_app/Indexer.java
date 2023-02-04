package com.example.poems_app;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;


public interface Indexer<T> {
	
	public void index(T item);
	public void indexAll(Iterable<T> items); 
	public void removeItem(T item) throws SolrServerException, IOException;
	public void clearIndex() throws SolrServerException, IOException;
}


