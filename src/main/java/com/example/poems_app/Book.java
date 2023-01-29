package com.example.poems_app;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.json.JSONObject;

@Entity
public class Book extends BibItem {

	private String isbn;
	private String publisher;
	private String date;
	private final String TYPE = "book";
	
	/**public Book(JSONObject jObj) {
	
		catch(Exception e) {
			
		}
		super(tmpTitle,tmpCreator,tmpIsbn,tmpPublisher,tmpDate);
		
		
	}*/
	
	public Book() {
		
	}
	
	public Book(String title, String author, String identifier, String isbn, String publisher, String date) {
		super(title, author, identifier);
		this.isbn = isbn;
		this.publisher = publisher;
		this.date = date;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
	    this.isbn = isbn;	
	}
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public boolean equals(Object o) {
			if (o == this) {
				return true;
			}

			if(!super.equals(o)) {
				return false;
			}
			
			if (!(o instanceof Book)) {
				return false;
			}

			Book book = (Book) o;
			
			return book.getIsbn().equals(this.isbn) && book.getPublisher().equals(this.publisher)
					&& book.getDate().equals(this.date);
		}
	}
	

