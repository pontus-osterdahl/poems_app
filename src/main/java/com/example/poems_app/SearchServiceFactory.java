package com.example.poems_app;

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
