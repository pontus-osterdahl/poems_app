package com.example.poems_app.xml;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DocTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private TitlePart titlePart;

	public TitlePart getTitlePart() {
		return titlePart;
	}

	public void setTitlePart(TitlePart titlePart) {
		this.titlePart = titlePart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
