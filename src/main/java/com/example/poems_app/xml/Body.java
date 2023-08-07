package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
