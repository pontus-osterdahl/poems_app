package com.example.poems_app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Front {
	
	private TitlePage titlePage;
	
	public void setTitlePage(TitlePage titlePage) {
		this.titlePage = titlePage;
	}
	
	@XmlElement(name="titlePage")
	public TitlePage getTitlePage() {
		return this.titlePage;
	}

}
