package com.example.poems_app.xml;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class XmlPoem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String filepath;
	
	private String name;
	
	/**
	 * private PoemDescription
	 * 
	 * private Bibliography
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Set<ContentItem> contentItems;
	
	public int getId() {
		return this.id;
	}
	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setContentItems(Set<ContentItem> contentItems) {
		this.contentItems = contentItems;
	}
	
	public Set<ContentItem> getContentItems() {
		return this.contentItems;
	}

}
