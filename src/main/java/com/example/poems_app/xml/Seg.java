package com.example.poems_app.xml;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Seg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JsonBackReference
	private XmlPoem xmlPoem;

	public int getId() {
		return this.id;
	}
	
	public Seg() {
		persons = new HashSet<String>();
		relations = new ArrayList<String>();
		placenames = new HashSet<String>();
	}
	
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

	public void setXmlPoem(XmlPoem xmlPoem) {
		this.xmlPoem = xmlPoem;
	}

	public XmlPoem getXmlPoem() {
		return this.xmlPoem;
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
	
	public String getTextId() {
		return "";
	}

	public void setTextId(String textId) {
		
	}
	
	@ElementCollection
	private List<String> relations;
	
	@ElementCollection
	private Set<String> persons;
	
	@ElementCollection
	private Set<String> placenames;
	
}
