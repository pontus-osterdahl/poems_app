package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ContentItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String textId;

	@ManyToOne
	@JsonBackReference
	private XmlPoem xmlPoem;

	public int getId() {
		return this.id;
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

	public String getTextId() {
		return this.textId;
	}

	public void setTextId(String textId) {
		this.textId = textId;
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

	@ElementCollection
	private List<String> relations;
}
