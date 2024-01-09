package com.example.poems_app;

import java.util.Set;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BibItem {

	protected String title;
	protected String author;
	protected String identifier;

	@ManyToMany
	protected Set<Poem> poems;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	protected BibItem() {

	}

	public Set<Poem> getPoems() {
		return this.poems;
	}

	public void addPoems(Poem poem) {
		this.poems.add(poem);
	}

	public void setBibItems(Set<Poem> poems) {
		this.poems = poems;
	}

	protected BibItem(String title, String author, String identifier) {
		this.title = title;
		this.author = author;
		this.identifier = identifier;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof BibItem)) {
			return false;
		}

		BibItem bibItem = (BibItem) o;

		return bibItem.getTitle().equals(this.title) && bibItem.getAuthor().equals(this.author)
				&& bibItem.getIdentifier().equals(this.identifier);
	}

}
