package com.example.poems_app.xml;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TitlePage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private DocTitle docTitle;

	private String type;
	
	public DocTitle getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(DocTitle docTitle) {
		this.docTitle = docTitle;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
