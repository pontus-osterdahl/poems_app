package com.example.poems_app.xml;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/**
 * Entity to store sections of letters within one part of manuscript.
 * @author pontu
 *
 */
@Entity
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String xmlId;

	@OneToMany(cascade = {CascadeType.ALL})
	private List<Letter> letters;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXmlId() {
		return xmlId;
	}

	public void setXmlId(String xmlId) {
		this.xmlId = xmlId;
	}

	public List<Letter> getLetters() {
		return letters;
	}

	public void setLetters(List<Letter> letters) {
		this.letters = letters;
	}
	
	
	
	
}
