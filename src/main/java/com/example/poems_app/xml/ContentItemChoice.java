package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ContentItemChoice {
	
	@OneToOne
	@JsonBackReference
	private ContentItem contentItem;
	@OneToOne
	private Orig orig;
	@OneToOne
	private Reg reg;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public void setContentitem(ContentItem contentItem) {
		this.contentItem = contentItem;
	}
	
	public ContentItem getContentItem() {
		return this.contentItem;
	}

	public void setReg(Reg reg) {
		this.reg = reg;
	}
	
	public Reg getReg() {
		return this.reg;
	}
	
	public void setOrig(Orig orig) {
		this.orig = orig;
	}
	
	public Orig getOrig() {
		return this.orig;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	
	
}
