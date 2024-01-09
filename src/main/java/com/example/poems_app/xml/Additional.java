package com.example.poems_app.xml;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Additional {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(cascade = {CascadeType.ALL})
	List<BiblPointer> biblPointers;

	public List<BiblPointer> getBiblPointers() {
		return biblPointers;
	}

	public void setBiblPointers(List<BiblPointer> biblPointers) {
		this.biblPointers = biblPointers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
