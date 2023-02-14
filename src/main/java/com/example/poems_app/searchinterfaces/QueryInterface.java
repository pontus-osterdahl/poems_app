package com.example.poems_app.searchinterfaces;

import java.util.List;

import com.example.poems_app.BibItem;

public interface QueryInterface {

	public List<BibItem> performQuery(String host, String query); 
	public List<BibItem> performQuery(String host, String query, int nrRecords); 
	
}
