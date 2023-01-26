package com.example.poems_app.queryModules;

import java.net.MalformedURLException;
import java.net.URL;

public class LibrisQueryModule implements QueryModule {

	private String baseUrl = "http://libris.kb.se/xsearch?";
	private String format = "";
	
	@Override
	public URL createQuery(String id) throws MalformedURLException {
		System.out.println(format);
		return new URL(baseUrl + "query=" + id + "&format=" + format);
	}

	@Override
	public void setFormat(String format) {
		this.format = format;
		
	}

}
