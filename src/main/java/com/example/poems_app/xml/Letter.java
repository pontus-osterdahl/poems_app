package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity to store persons beginning with the same letter
 *
 */
@Entity
public class Letter {

	@Id
	private int id;
	
	private String xmlId;
	
	@OneToMany
	private List<AuthorSection> authors;

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

	public List<AuthorSection> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorSection> authors) {
		this.authors = authors;
	}
}
