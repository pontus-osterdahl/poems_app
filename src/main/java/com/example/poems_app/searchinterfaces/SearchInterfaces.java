package com.example.poems_app.searchinterfaces;

public enum SearchInterfaces {
	
	XSEARCH("Xsearch");
	
    private String type;
	private SearchInterfaces(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
	
}
