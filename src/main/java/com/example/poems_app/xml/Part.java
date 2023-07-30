package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity to store sections of letters within one part of manuscript.
 * @author pontu
 *
 */
@Entity
public class Part {

	@Id
	private int id;
	
	private String xmlId;

	@OneToMany
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
