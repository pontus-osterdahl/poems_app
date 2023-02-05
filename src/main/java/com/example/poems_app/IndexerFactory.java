package com.example.poems_app;

import com.example.poems_app.services.PoemIndexer;

public class IndexerFactory{
	static public Indexer getIndexer(String indexer) {
		if(indexer.equals("POEM"))
		{
			return new PoemIndexer();
		}
		else {
			return null;
		}
	}
}


