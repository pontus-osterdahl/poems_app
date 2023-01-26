package com.example.poems_app.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.example.poems_app.BibItem;
import com.example.poems_app.BibItemReader;
import com.example.poems_app.queryExecutors.BibItemQueryExecutor;
import com.example.poems_app.queryModules.QueryModule;

public class Importer {

	// Handles logic for creating query
	private QueryModule queryMod;
	//private BibItemReader bibRead;
	private BibItemQueryExecutor queryExecutor;
	
	
	public Importer(QueryModule queryMod, BibItemQueryExecutor queryExecutor) {
		this.queryMod = queryMod;
		//this.bibRead = bibRead;
		this.queryExecutor = queryExecutor;
	}
	
	public List<BibItem> importItems(String id) throws IOException {
        URL query = queryMod.createQuery(id);		
		
        List<BibItem> bibItems = queryExecutor.executeQuery(query);
        
        return bibItems;		
		
		
	}
	
	
}
