package com.example.poems_app.xml;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Entity to store segments of one specific author. 
 *
 */

@Entity
public class AuthorSection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String authorId;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Seg> segments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public List<Seg> getSegments() {
		return segments;
	}

	public void setSegments(List<Seg> segments) {
		this.segments = segments;
	}
	
}
