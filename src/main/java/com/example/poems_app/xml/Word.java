package com.example.poems_app.xml;

import javax.persistence.Entity;

@Entity
public class Word extends Break {
	
	public Word() {
		type = "WORD";
	}

}
