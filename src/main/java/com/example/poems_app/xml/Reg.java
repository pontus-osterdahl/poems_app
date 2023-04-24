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

public class Reg extends ApophthegmText {
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JsonBackReference
	private ContentItemChoice contentItemChoice;
	
	
	private String criticalApparatus;
	
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
