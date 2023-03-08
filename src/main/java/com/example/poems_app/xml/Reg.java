package com.example.poems_app.xml;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reg {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private ContentItemChoice choice;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setContentItemChoice(ContentItemChoice choice) {
		this.choice = choice;
	}
	
	public ContentItemChoice getContentItemChoice() {
		return this.choice;
	}
}
