package com.example.poems_app.xml;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Reg {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JsonBackReference
	private ContentItemChoice contentItemChoice;
	
	
	private String criticalApparatus;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setCriticalApparatus(String criticalApparatus) {
		this.criticalApparatus = criticalApparatus;
	}
	
	public String getCriticalApparatus() {
		return this.criticalApparatus;
	}
	
	public void setContentItemChoice(ContentItemChoice contentItemChoice) {
		this.contentItemChoice = contentItemChoice;
	}
	
	public ContentItemChoice getContentItemChoice() {
		return this.contentItemChoice;
	}
}
