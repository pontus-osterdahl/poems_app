package com.example.poems_app.queryExecutors;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.example.poems_app.BibItem;

public interface BibItemQueryExecutor {

	public List<BibItem> executeQuery(URL query) throws IOException;
	
}
