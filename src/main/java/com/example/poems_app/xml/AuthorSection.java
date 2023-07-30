package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity to store segments of one specific author. 
 *
 */

@Entity
public class AuthorSection {

	@Id
	private int id;
	
	private String authorId;
	
	@OneToMany
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
