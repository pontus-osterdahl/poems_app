package com.example.poems_app;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlTransient;

import org.apache.solr.common.SolrInputDocument;

import com.example.poems_app.services.SolrDocumentCreator;
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
