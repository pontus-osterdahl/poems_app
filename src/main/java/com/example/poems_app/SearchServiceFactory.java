package com.example.poems_app;

import com.example.poems_app.services.PoemSearchService;
import com.example.poems_app.services.SearchService;

public class SearchServiceFactory {

	public static SearchService getSearchService(String service)
	{
		if(service == null) {
			return null;
		}
		else if(service.equalsIgnoreCase("POEM")){
		    return new PoemSearchService();	
		}
		return null;
	}
	
}
