package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Reg extends ApophthegmText {
		
	private String criticalApparatus;
	
	@Lob
	protected String text;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setCriticalApparatus(String criticalApparatus) {
		this.criticalApparatus = criticalApparatus;
	}
	
	public String getCriticalApparatus() {
		return this.criticalApparatus;
	}

	

}
