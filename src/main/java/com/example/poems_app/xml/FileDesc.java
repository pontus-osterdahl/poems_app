package com.example.poems_app.xml;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class FileDesc {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private TitleStatement titleStatement;
	
	private String publicationStatement;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private SourceDescription sourceDescription;

	public TitleStatement getTitleStatement() {
		return titleStatement;
	}

	public void setTitleStatement(TitleStatement titleStatement) {
		this.titleStatement = titleStatement;
	}

	public String getPublicationStatement() {
		return publicationStatement;
	}

	public void setPublicationStatement(String publicationStatement) {
		this.publicationStatement = publicationStatement;
	}

	public SourceDescription getSourceDescription() {
		return sourceDescription;
	}

	public void setSourceDescription(SourceDescription sourceDescription) {
		this.sourceDescription = sourceDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
