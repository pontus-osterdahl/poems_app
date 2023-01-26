package com.example.poems_app;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@XmlRootElement
@Entity
public class Poem implements Indexable {
	
	private final String INDEXNAME = "poem";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("title")
	private String title;
	
	public int getId(){
		return this.id;
	}
	
	@XmlAttribute
	public void setId(int id){
		this.id = id;
	}
	
	public String getText() {
		return this.text;
	}
	
	@XmlElement(name="text")
	public void setText(String text) {
		this.text = text;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	@XmlElement(name="title")
	public void setTitle(String title) {
		this.title = title;
	}

	@XmlTransient
	@Override
	public String getIndexName() {
		return this.INDEXNAME;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Poem p = (Poem) o;
		return this.id == p.id && this.text.equals(p.text) && this.title.equals(p.title);
		
	}
	
}
