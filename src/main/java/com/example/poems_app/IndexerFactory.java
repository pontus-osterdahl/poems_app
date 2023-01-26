package com.example.poems_app;

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

/**abstract class IndexerFactory {

	protected abstract Indexer factoryMethod();
	
	public Indexer getIndexer() {
		return factoryMethod();
	}
	
}

class PoemIndexerFactory extends IndexerFactory{
	protected Indexer factoryMethod() {
		return new PoemIndexer();
	}
}*/


