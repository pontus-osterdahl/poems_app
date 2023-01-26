package com.example.poems_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

public class LibrisReader implements BibItemReader {
	
	@Override
	public BibItem getBibItem(JSONObject jObj) {
	
		BibItem bibItem = parseJson(jObj);
		//BibItem bibItem = BibItemJsonFactory.createBibItem(jObj);
		return bibItem;
	}
	
	private String getFirstStringHelper(JSONObject jObj, String type) {
		Object obj = jObj.get(type);
		if (obj instanceof String) {
			return (String) obj;
		}
		else if(obj instanceof JSONArray) {
			return ((JSONArray) obj).getString(0);
		} 
		
		return "";
		
	}
	
	private Book parseJsonToBook(JSONObject jObj) {
		String tmpTitle = getFirstStringHelper(jObj, "title");
		String tmpAuthor = getFirstStringHelper(jObj, "creator");
		String tmpPublisher = getFirstStringHelper(jObj, "publisher");
		String tmpIsbn = getFirstStringHelper(jObj, "isbn");
		String tmpDate = getFirstStringHelper(jObj, "date");
		String tmpIdentifier = getFirstStringHelper(jObj, "identifier");
		
		/**
		try {
			tmpTitle = jObj.getString("title");
			tmpPublisher = jObj.getString("publisher");
			tmpAuthor = jObj.getString("creator");
			tmpIsbn = jObj.getString("isbn");
			tmpDate = jObj.getString("date");
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		return new Book(tmpTitle,tmpAuthor,tmpIsbn,tmpPublisher,tmpDate,tmpIdentifier);
		
	}
	
	private BibItem parseJson(JSONObject jObj) {
		String type = jObj.getString("type");
		
		if("book".equals(type)) {
			return parseJsonToBook(jObj);
		}
		
		return null;
		//BibItem bibItem = BibItemFactory.createBibItem(type);
		//JsonParser.parseBibItem(bibItem);
	}
	
	@Override
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
}

class BibItemFactory {
	public static BibItem createBibItem(String type) {
		if("book".equals(type)) {
			return new Book();
			
		}
		return null;
	}
}

class JsonParser {
	
	public static void parseBibItem(Book bibItem) {
		
	}
	
}

/**
class Visitor {
	public BibItem g
}

class BibItemJsonFactory {
	
	public static BibItem createBibItem(JSONObject jObj) {
		String type = jObj.getString("type");
		if("book".equals(type)) {
			String tmpTitle = "";
			String tmpAuthor = "";
			String tmpPublisher = "";
			String tmpIsbn = "";
			String tmpDate = "";
			
			try {
				tmpTitle = jObj.getString("title");
				tmpPublisher = jObj.getString("publisher");
				tmpAuthor = jObj.getString("creator");
				tmpIsbn = jObj.getString("isbn");
				tmpDate = jObj.getString("date");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return new Book(tmpTitle,tmpAuthor,tmpIsbn,tmpPublisher,tmpDate);
			
		}
	    return null;
	}
	
	
	
}*/
