package com.example.poems_app.xml;

import javax.persistence.Entity;

@Entity
public class PageBreak extends Break {

	public PageBreak() {
		type = "PAGE_BREAK";
	}
	
}
