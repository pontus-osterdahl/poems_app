package com.example.poems_app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BibItemSource {

	@Column(unique=true)
	private String name;
	
	private String host;
	
	private String interfaceType;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public void setHost (String host) {
		this.host = host;
	}
	
	public void setInterfaceType (String interfaceType) {
		this.interfaceType = interfaceType; 
	}
	
	public String getHost () {
		return this.host;
	}
	
	public String getInterfaceType () {
		return this.interfaceType;
	}
	
	public void setName (String name) {
		this.name = name; 
	}
	
	public String getName () {
		return this.name;
	}
	
	public int getId () {
		return this.id;
	}
	
	public void setId (int id) {
		this.id = id;
	}
}

