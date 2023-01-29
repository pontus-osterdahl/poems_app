package com.example.poems_app;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;

public interface IndexDatabaseSyncher<T extends Indexable> {
	public void updateIndex(Iterable<T> currentIndexItems, Iterable<T> currentDbItems, Indexer<T> indexer) throws SolrServerException, IOException;
}
	


                 