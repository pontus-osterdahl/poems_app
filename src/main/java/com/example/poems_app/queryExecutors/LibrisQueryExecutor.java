package com.example.poems_app.queryExecutors;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.example.poems_app.BibItem;
import com.example.poems_app.BibItemReader;
import com.example.poems_app.LibrisReader;

public class LibrisQueryExecutor implements BibItemQueryExecutor {
	
	private BibItemReader bibItemReader = new LibrisReader();
	
	@Override
	public List<BibItem> executeQuery(URL query) throws IOException {
	    String json = IOUtils.toString(query, Charset.forName("UTF-8"));
	    List<BibItem> bibItems = bibItemReader.parseQueryResult(new JSONObject(json));
	    return bibItems;
	}
}
