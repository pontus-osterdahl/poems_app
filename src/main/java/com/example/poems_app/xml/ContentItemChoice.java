package com.example.poems_app.xml;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ContentItemChoice {
	
	/**@OneToOne(cascade = {CascadeType.ALL})
	private Orig orig;
	@OneToOne(cascade = {CascadeType.ALL})
	private Reg reg;
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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
	}*/
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public ContentItem getContentItem() {
		return contentItem;
	}
	
	public void setContentItem(ContentItem contentItem) {
		this.contentItem = contentItem;
		
	}
	
	
	
}
