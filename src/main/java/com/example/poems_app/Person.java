package com.example.poems_app;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ElementCollection
	private List<BibItem> publications;
	
	
	public void setPublications(List<BibItem> publications) {
		this.publications = publications;
	}
	
	public List<BibItem> getPublications() {
		return this.publications;
	}
	
}
