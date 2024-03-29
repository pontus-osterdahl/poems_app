package com.example.poems_app.xml;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ObjectDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private SupportDescription supportDescription;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private LayoutDescription layoutDescription;
	
	public void setSupportDescription(SupportDescription supportDescription) {
		this.supportDescription = supportDescription;
	}
	
	public SupportDescription getSupportDescription() {
		return this.supportDescription;
	}

	public LayoutDescription getLayoutDescription() {
		return layoutDescription;
	}

	public void setLayoutDescription(LayoutDescription layoutDescription) {
		this.layoutDescription = layoutDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
