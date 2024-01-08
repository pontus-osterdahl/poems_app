package com.example.poems_app.xml;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class XmlPoem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String filepath;
	
	private String name;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Text text;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private TeiHeader teiHeader;
	
	/**
	 * private PoemDescription
	 * 
	 * private Bibliography
	 */
	
	
	/**
	@OneToMany(cascade = {CascadeType.ALL})
	private Set<ContentItem> contentItems;
	*/
	
	public void setId(int id) {
		this.id = id;
	}

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

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public TeiHeader getTeiHeader() {
		return teiHeader;
	}

	public void setTeiHeader(TeiHeader teiHeader) {
		this.teiHeader = teiHeader;
	}
	
	/**public void setContentItems(Set<ContentItem> contentItems) {
		this.contentItems = contentItems;
	}
	
	public Set<ContentItem> getContentItems() {
		return this.contentItems;
	}*/

}
