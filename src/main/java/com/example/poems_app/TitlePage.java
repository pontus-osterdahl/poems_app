package com.example.poems_app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TitlePage {
	@XmlElement(name="docTitle")
	private DocTitle docTitle;
	
	public void setTitle(String title) {
		docTitle.setTitle(title);
	}
	
	public String getTitle() {
		return this.docTitle.getTitle();
	}
}
