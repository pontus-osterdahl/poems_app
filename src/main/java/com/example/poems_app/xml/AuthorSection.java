package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Enttity to store segments of one specific author. 
 *
 */

@Entity
public class AuthorSection {

	@Id
	private int id;
	
	private String authorId;
	
	@OneToMany
	private List<Seg> segments;
	
}
