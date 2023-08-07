package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ObjectDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private SupportDescription supportDescription;
	
	@OneToOne
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
