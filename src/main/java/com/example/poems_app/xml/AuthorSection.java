package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
