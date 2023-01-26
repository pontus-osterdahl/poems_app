package com.example.poems_app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlValue;

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