package com.example.poems_app;

public class XmlPoemCreationRequest {

	String filePath;
	int id;
	
	public XmlPoemCreationRequest() {
		
	}
	
	public XmlPoemCreationRequest(String filePath, int id) {
		this.filePath = filePath;
		this.id = id;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
