package com.example.poems_app.factories;

public class AbstractQueryFactory {

	public static QueryFactoryInterface getFactory(String type) {
		
		QueryFactoryInterface queryInterface = null;
		
		if("libris".equals(type.toLowerCase())) {
			queryInterface = new LibrisQueryFactory();
		}
		
		return queryInterface;
	}
	
}
