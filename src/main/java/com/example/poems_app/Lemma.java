package com.example.poems_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlValue;

import org.apache.solr.common.annotation.JsonProperty;

abstract class Lemma {

	@JsonProperty("content")	
    protected String content;	
	@XmlValue
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
    abstract public String getType();
}

@XmlRootElement(name="w")
class Word extends Lemma {

	private final String TYPE = "word";
	
	@JsonProperty("language")
	private String language;
	
	@Override
	public String getType() {
		return this.TYPE;
	}
	
	@XmlAttribute(name="language")
	public String getLanguage() {
		return this.language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
}

@XmlRootElement(name="p")
class PlaceName extends Lemma {
	private final String TYPE = "placename";
	
	@Override
	public String getType() {
		return this.TYPE;
	}
	
}

@XmlRootElement(name="d")
class Diacritic extends Lemma {
	
	
	private final String TYPE = "diacritic";
	
	@Override
	public String getType() {
		return this.TYPE;
	}
	
	
}