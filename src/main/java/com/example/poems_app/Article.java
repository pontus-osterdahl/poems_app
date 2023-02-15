package com.example.poems_app;

import javax.persistence.Entity;

@Entity
public class Article extends BibItem {
    private String journal;
    private String year;
    private int volume;
    private int number;
    private String pages;
    private final String TYPE = "article";
    
    public Article() {
    	
    }
    
    public Article(String title, String author, String identifier, String journal, String year, int volume, int number, String pages) {
		super(title, author, identifier);
		this.journal = journal;
		this.year = year;
		this.volume = volume;
		this.number = number;
		this.pages = pages;
	}
    
    public void setJournal(String journal) {
    	this.journal = journal;
    }
    
    public String getJournal() {
    	return this.journal;
    }
    
    public void setYear(String year) {
    	this.year = year;
    }
    
    public String getYear() {
    	return this.year;
    }
    
    public void setVolume(int volume) {
    	this.volume = volume;
    }
    
    public int getVolume() {
    	return this.volume;
    }
    
    public void setNumber(int number) {
    	this.number = number;
    }
    
    public int getNumber() {
    	return this.number;
    }
    
    public void setPages(String pages) {
    	this.pages = pages;
    }
    
    public String getPages() {
    	return this.pages;
    }
    
    
}
