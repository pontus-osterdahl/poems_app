package com.example.poems_app.xml;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Layout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public Layout() {
		
	}
	
	public Layout(int columns, int ruledLines, String content) {
		super();
		this.columns = columns;
		this.ruledLines = ruledLines;
		this.content = content;
	}
	private int columns;
	private int ruledLines;
	private String content;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public int getRuledLines() {
		return ruledLines;
	}
	public void setRuledLines(int ruledLines) {
		this.ruledLines = ruledLines;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
