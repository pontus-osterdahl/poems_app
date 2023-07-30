package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Front {
	
	@OneToOne
	private TitlePage titlePage;

	public TitlePage getTitlePage() {
		return titlePage;
	}

	public void setTitlePage(TitlePage titlePage) {
		this.titlePage = titlePage;
	}

}
