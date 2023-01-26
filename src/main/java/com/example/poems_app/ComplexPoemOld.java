package com.example.poems_app;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="poem")
public class ComplexPoemOld implements Indexable {

    private int id;
	
    private final String INDEXNAME = "complexPoem"; 
    
	@JsonProperty("text")
	private ComplexPoem text;
	
	@JsonProperty("title")
	private String title;
	
	public int getId(){
		return this.id;
	}
	
	@XmlAttribute
	public void setId(int id){
		this.id = id;
	}
	
	public void setText(ComplexPoem text) {
		this.text = text;
	}
	
	@XmlElement(name="text")
	public ComplexPoem getText() {
		return this.text;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	@XmlElement(name="title")
	public void setTitle(String title) {
		this.title = title;
	}	
	
	@XmlTransient
	public String getIndexName() {
		return INDEXNAME;
	}
	
}
