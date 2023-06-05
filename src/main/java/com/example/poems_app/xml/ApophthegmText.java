package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ApophthegmText {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	protected String text;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
}
