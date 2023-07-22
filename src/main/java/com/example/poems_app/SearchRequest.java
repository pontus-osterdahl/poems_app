package com.example.poems_app;

public class SearchRequest {

	private String lemma;
	
	private SearchType searchType;
	
	private String searchReturn;

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public SearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}

	public String getSearchReturn() {
		return searchReturn;
	}

	public void setSearchReturn(String searchReturn) {
		this.searchReturn = searchReturn;
	}
	
	public SearchRequest(String lemma, SearchType searchType, String searchReturn) {
		this.lemma = lemma;
		this.searchType = searchType;
		this.searchReturn = searchReturn;
	}
}
