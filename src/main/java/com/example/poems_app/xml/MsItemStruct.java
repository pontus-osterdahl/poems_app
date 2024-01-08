package com.example.poems_app.xml;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class MsItemStruct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public MsItemStruct() {
		
	}
	
	public MsItemStruct(Locus locus, String author, String title, String note, String textLang) {
		this.locus = locus;
		this.author = author;
		this.title = title;
		this.note = note;
		this.textLang = textLang;
	}

	@OneToOne(cascade = { CascadeType.ALL })
	private Locus locus;
	private String author;
	private String title;
	private String note;
	private String textLang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Locus getLocus() {
		return locus;
	}

	public void setLocus(Locus locus) {
		this.locus = locus;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTextLang() {
		return textLang;
	}

	public void setTextLang(String textLang) {
		this.textLang = textLang;
	}

}
