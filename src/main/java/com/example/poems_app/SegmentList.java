package com.example.poems_app;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="div")
public class SegmentList {
	
	private List<Segment> segments;
	
	@XmlElement(name="ab")
	public List<Segment> getSegments() {
		return this.segments;
	}
	
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	
	private String id;
    
	@XmlAttribute(name="id", namespace="http://www.w3.org/XML/1998/namespace")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
    
    
}
