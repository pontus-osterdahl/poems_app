package com.example.poems_app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="docTitle")
public class DocTitle {
	
	@XmlElement(name="titlePart")
    private String titlePart;
    
    public void setTitle(String title) {
    	this.titlePart = title;
    }
    
    public String getTitle() {
    	return this.titlePart;
    }
}
