package com.example.poems_app;

public class XmlPoemCreatedMessage {
	
    int xmlPoemCreationRequestId;
    int xmlPoemId;
    String xmlPoemTitle;
    String xmlPoemFilePath;
    
	public int getXmlPoemCreationRequestId() {
		return xmlPoemCreationRequestId;
	}
	public void setXmlPoemCreationRequestId(int xmlPoemCreationRequestId) {
		this.xmlPoemCreationRequestId = xmlPoemCreationRequestId;
	}
	public int getXmlPoemId() {
		return xmlPoemId;
	}
	public void setXmlPoemId(int xmlPoemId) {
		this.xmlPoemId = xmlPoemId;
	}
	public String getXmlPoemTitle() {
		return xmlPoemTitle;
	}
	public void setXmlPoemTitle(String xmlPoemTitle) {
		this.xmlPoemTitle = xmlPoemTitle;
	}
	public String getXmlPoemFilePath() {
		return xmlPoemFilePath;
	}
	public void setXmlPoemFilePath(String xmlPoemFilePath) {
		this.xmlPoemFilePath = xmlPoemFilePath;
	}
    
    public XmlPoemCreatedMessage() {
    	
    }
    
    public XmlPoemCreatedMessage(int xmlPoemCreationRequestId, int xmlPoemId, String xmlPoemTitle, String xmlPoemFilePath) {
    	this.xmlPoemCreationRequestId = xmlPoemCreationRequestId;
    	this.xmlPoemId = xmlPoemId;
    	this.xmlPoemTitle = xmlPoemTitle;
    	this.xmlPoemFilePath = xmlPoemFilePath;
    }
    
    
}
