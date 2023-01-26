package com.example.poems_app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="titleStmt")
public class TitleStmt {
	
    private String title;
	
    public void setTitle(String title) {
    	this.title = title;
    }
    
    @XmlElement(name="title")
	public String getTitle() {
		return this.title;
	}
}
