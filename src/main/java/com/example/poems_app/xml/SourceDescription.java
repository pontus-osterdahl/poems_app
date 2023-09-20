package com.example.poems_app.xml;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
