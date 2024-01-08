package com.example.poems_app.xml;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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

	@OneToOne(cascade = {CascadeType.ALL})
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
