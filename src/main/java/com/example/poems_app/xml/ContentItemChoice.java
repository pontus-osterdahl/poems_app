package com.example.poems_app.xml;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ContentItemChoice {
	
	private Orig orig;
	
	private Reg reg;
	
	private ContentItem contentItem;

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
	
	
	public ContentItem getContentItem() {
		return contentItem;
	}
	
	public void setContentItem(ContentItem contentItem) {
		this.contentItem = contentItem;
		
	}	
}
