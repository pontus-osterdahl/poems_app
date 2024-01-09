package com.example.poems_app.xml;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LineBreak extends Break {

	public LineBreak() {
		type = "LINE_BREAK";
	}

}
