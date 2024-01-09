package com.example.poems_app.xml;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SourceDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	ManuscriptDescription manusciptDescription;

	public ManuscriptDescription getManusciptDescription() {
		return manusciptDescription;
	}

	public void setManusciptDescription(ManuscriptDescription manusciptDescription) {
		this.manusciptDescription = manusciptDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
}
