package com.example.poems_app.xml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ContentItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique=true)
	private String textId;
	
	@OneToOne
	private ContentItemChoice choice;
	
	@ManyToOne
	@JsonBackReference
	private XmlPoem xmlPoem;
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setXmlPoem(XmlPoem xmlPoem) {
		this.xmlPoem = xmlPoem;
	}
	
	public XmlPoem getXmlPoem() {
		return this.xmlPoem;
	}
	
	public void setChoice(ContentItemChoice choice) {
		this.choice = choice;
	}
	
	public ContentItemChoice getChoice() {
		return this.choice;
	}
	
	public String getTextId() {
		return this.textId;
	}
	
	public void setTextId(String textId) {
		this.textId = textId;
	}
	
	
	
	
	
}
