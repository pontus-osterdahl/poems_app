package com.example.poems_app;

import java.util.List;

import org.json.JSONObject;

public interface BibItemReader {

	public List<BibItem> parseQueryResult(JSONObject jObj);
	
	public BibItem getBibItem(JSONObject jObj);
	
}
