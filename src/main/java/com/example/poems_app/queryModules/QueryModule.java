package com.example.poems_app.queryModules;

import java.net.MalformedURLException;
import java.net.URL;

public interface QueryModule {
	public URL createQuery(String id) throws MalformedURLException;
	public void setFormat(String format);
}
