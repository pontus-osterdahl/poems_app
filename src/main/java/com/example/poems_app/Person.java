package com.example.poems_app;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
