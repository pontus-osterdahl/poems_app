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
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="text")
public class Text {

	private Body body;
	private Front front;
	private String id;
	
	public void setFront(Front front) {
		this.front = front;
	}
	
	public void setBody(Body body) {
		this.body = body;
	}
	
	@XmlElement(name="body")
	public Body getBody() {
		return this.body;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name="id",namespace="http://www.w3.org/XML/1998/namespace")
	public String getId() {
		return this.id;
	}
	
	@XmlElement(name="front") 
	public Front getFront() {
		return this.front;
	}
}

