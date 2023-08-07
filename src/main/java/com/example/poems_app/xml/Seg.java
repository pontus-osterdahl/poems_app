package com.example.poems_app.xml;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Seg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return this.id;
	}
	
	public Seg() {
		persons = new HashSet<String>();
		relations = new ArrayList<String>();
		placenames = new HashSet<String>();
	}
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private AuthorSection authorSection;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Orig orig;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Reg reg;

	public Orig getOrig() {
		return orig;
	}

	public void setOrig(Orig orig) {
		this.orig = orig;
	}

	public Reg getReg() {
		return reg;
	}

	public void setReg(Reg reg) {
		this.reg = reg;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRelations(List<String> relations) {
		this.relations = relations;
	}

	public List<String> getRelations() {
		return this.relations;
	}

	public void addRelation(String relation) {
		this.relations.add(relation);
	}
	
	public void setPersons(Set<String> persons) {
		this.persons = persons;
	}

	public Set<String> getPersons() {
		return this.persons;
	}

	public void addPerson(String relation) {
		this.persons.add(relation);
	}
	
	public void setPlacenames(Set<String> placenames) {
		this.placenames = placenames;
	}

	public Set<String> getPlacenames() {
		return this.placenames;
	}

	public void addPlacename(String placename) {
		this.placenames.add(placename);
	}
	
	public abstract String getTextId();

	public abstract void setTextId(String textId);
	
	@ElementCollection
	private List<String> relations;
	
	@ElementCollection
	private Set<String> persons;
	
	@ElementCollection
	private Set<String> placenames;

	public AuthorSection getAuthorSection() {
		return authorSection;
	}

	public void setAuthorSection(AuthorSection authorSection) {
		this.authorSection = authorSection;
	}	
}
