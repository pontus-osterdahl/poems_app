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
	
	@OneToMany
	private List<AuthorSection> authors;
}
