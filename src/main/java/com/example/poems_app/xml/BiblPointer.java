package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.poems_app.BibItem;

@Entity
public class BiblPointer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public BiblPointer(BibItem bibItem, String biblScope) {
		this.bibItem = bibItem;
		this.biblScope = biblScope;
	}

	@OneToOne
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
