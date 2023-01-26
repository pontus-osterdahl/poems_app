package com.example.poems_app;

public class QueryForm {

	private String queryType;
	private String queryValue;
	private String format;
	
	public QueryForm(String queryType, String queryValue) {
		this(queryType,queryValue,"");
	}
	
	public QueryForm() {
		
	}
	
	public QueryForm(String queryType, String queryValue, String format) {
		this.queryType = queryType;
		this.queryValue = queryValue;
		this.format = format;
	}
	
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	
	public String getQueryType() {
		return this.queryType;
	}
	
	public String getQueryValue() {
		return this.queryValue;
	}
	
	public String getFormat() {
		return this.format;
	}
	
	
}
