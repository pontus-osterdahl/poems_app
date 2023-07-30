package com.example.poems_app.xml;

import javax.persistence.OneToMany;

import com.example.poems_app.BibItem;

public class BiblPointer {

	public BiblPointer(BibItem bibItem, String biblScope) {
		this.bibItem = bibItem;
		this.biblScope = biblScope;
	}

	@OneToMany
	BibItem bibItem;

	String biblScope;

	public BibItem getBibItem() {
		return bibItem;
	}

	public void setBibItem(BibItem bibItem) {
		this.bibItem = bibItem;
	}

	public String getBiblScope() {
		return biblScope;
	}

	public void setBiblScope(String biblScope) {
		this.biblScope = biblScope;
	}
	
}
