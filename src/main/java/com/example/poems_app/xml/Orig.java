package com.example.poems_app.xml;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Orig extends ApophthegmText {
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Break> breaks;
	
	public Orig() {
		
	}

	public List<Break> getBreaks() {
		return breaks;
	}

	public void setBreaks(List<Break> breaks) {
		this.breaks = breaks;
	}	
}
