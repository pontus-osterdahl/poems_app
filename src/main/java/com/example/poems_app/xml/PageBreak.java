package com.example.poems_app.xml;

import jakarta.persistence.Entity;

@Entity
public class PageBreak extends Break {

	public PageBreak() {
		type = "PAGE_BREAK";
	}
	
}
