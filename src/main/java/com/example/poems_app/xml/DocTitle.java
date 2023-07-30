package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class DocTitle {

	@OneToOne
	private TitlePart titlePart;

	public TitlePart getTitlePart() {
		return titlePart;
	}

	public void setTitlePart(TitlePart titlePart) {
		this.titlePart = titlePart;
	}
	
}
