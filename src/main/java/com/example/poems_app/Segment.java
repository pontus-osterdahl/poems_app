package com.example.poems_app;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ab")
public class Segment {
	
	private List<Fragment> fragments;
	private String id;
	
	@XmlAttribute(name="id",namespace="http://www.w3.org/XML/1998/namespace")
    public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement(name="seg")
	public List<Fragment> getFragments() {
		return this.fragments;
	}
	
	public void setFragments(List<Fragment> fragments) {
		this.fragments = fragments;
	}
	
	
	
	
}
