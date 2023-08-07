package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Additional {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany
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
