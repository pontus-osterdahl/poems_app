package com.example.poems_app;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

public interface Indexer<T> {

	public void index(T item);

	public void indexAll(Iterable<T> items);

	public void removeItem(T item) throws SolrServerException, IOException;

	public void clearIndex() throws SolrServerException, IOException;
}
