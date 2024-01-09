package com.example.poems_app.xml;

import jakarta.persistence.Entity;

@Entity
public class Supplement extends Break {

	public Supplement() {
		type = "SUPPLEMENT";
	}
	
}
