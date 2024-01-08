package com.example.poems_app.xml;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Body {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
	
	@OneToMany(cascade = {CascadeType.ALL})
	List<Part> parts;

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
	
	
}
