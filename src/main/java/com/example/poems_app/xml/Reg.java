package com.example.poems_app.xml;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Reg extends ApophthegmText {
		
	private String criticalApparatus;
	
	public void setCriticalApparatus(String criticalApparatus) {
		this.criticalApparatus = criticalApparatus;
	}
	
	public String getCriticalApparatus() {
		return this.criticalApparatus;
	}

	

}
