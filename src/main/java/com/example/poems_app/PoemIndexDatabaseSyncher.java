package com.example.poems_app;

import java.io.IOException;
import java.util.HashMap;

import org.apache.solr.client.solrj.SolrServerException;

public class PoemIndexDatabaseSyncher implements IndexDatabaseSyncher<Poem>{
	
	@Override
	public void updateIndex(Iterable<Poem> currentIndexItems, Iterable<Poem> currentDbItems, Indexer<Poem> indexer)
			throws SolrServerException, IOException {
		
		HashMap<Integer,Poem> dbItems = convertToMap(currentDbItems);
    	//remove index items not in db
    	for(Poem p : currentIndexItems) {
    		Poem tmpPoem = dbItems.get(p.getId());
    		if (tmpPoem == null) {
    			indexer.removeItem(p);
    		}
    	}
        //reindex all db items
    	indexer.indexAll(currentDbItems);
		
	}
    
    //helper method
    private HashMap<Integer,Poem> convertToMap(Iterable<Poem> poems) {
    	HashMap<Integer, Poem> poemMaps = new HashMap<Integer, Poem>();
    	for (Poem p : poems) {
    		poemMaps.put(p.getId(), p);
    	}
    	return poemMaps;
    }
}
