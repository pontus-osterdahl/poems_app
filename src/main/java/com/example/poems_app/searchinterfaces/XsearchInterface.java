package com.example.poems_app.searchinterfaces;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.poems_app.BibItem;
import com.example.poems_app.Book;

public class XsearchInterface implements QueryInterface {

	private final int DEFAULT_NR_RECORDS = 10;
	
	@Override
	public List<BibItem> performQuery(String host, String query) {
		return performQuery(host,query,DEFAULT_NR_RECORDS);
	}
	
	public BibItem getBibItem(JSONObject jObj) {
		
		BibItem bibItem = parseJson(jObj);
		return bibItem;
	}
	
	private String getFirstStringHelper(JSONObject jObj, String type) {
		
		String val = "";
		
		try {
			Object obj = jObj.get(type);
		    if (obj instanceof String) {
			    val =  (String) obj;
		    }
		    else if(obj instanceof JSONArray) {
			    val = ((JSONArray) obj).getString(0);
		    } 
		}
		catch (Exception e) {
			
		}
		return val;
		
	}
	
	private Book parseJsonToBook(JSONObject jObj) {
		String tmpTitle = getFirstStringHelper(jObj, "title");
		String tmpAuthor = getFirstStringHelper(jObj, "creator");
		String tmpPublisher = getFirstStringHelper(jObj, "publisher");
		String tmpIsbn = getFirstStringHelper(jObj, "isbn");
		String tmpDate = getFirstStringHelper(jObj, "date");
		String tmpIdentifier = getFirstStringHelper(jObj, "identifier");

		return new Book(tmpTitle,tmpAuthor,tmpIsbn,tmpPublisher,tmpDate,tmpIdentifier);
		
	}
	
	private BibItem parseJson(JSONObject jObj) {
		String type = jObj.getString("type");
		
		if("book".equals(type)) {
			return parseJsonToBook(jObj);
		}
		
		return null;
	}
	
	public List<BibItem> parseQueryResult(JSONObject jObj) {
		List<BibItem> list = new ArrayList<BibItem>();
		JSONObject jObj2 = (JSONObject) jObj.get("xsearch");
		
		JSONArray jArr = (JSONArray) jObj2.get("list");
		for(int i = 0; i < jArr.length(); i++) {
			JSONObject bibJson = (JSONObject) jArr.get(i);
			BibItem bibItem = getBibItem(bibJson);
			if(Objects.nonNull(bibItem)) {
				list.add(bibItem);
			}
		}
		return list;
	}
	
	public List<BibItem> performQuery(URL url) throws IOException {
		String json = url.toString();
		return parseQueryResult(new JSONObject(json));
	}
	
	
	@Override
	public List<BibItem> performQuery(String host, String query, int nrRecords) {
		URL url = null;
		List<BibItem> bibItems = null;
		try {
			url = new URL(host + query + "&n=" + nrRecords + "&format=json");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			String json = IOUtils.toString(url, Charset.forName("UTF-8"));
			bibItems = parseQueryResult(new JSONObject(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bibItems;
	}
}
