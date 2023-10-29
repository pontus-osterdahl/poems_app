package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineBreak extends Break {

	public LineBreak() {
		type = "LINE_BREAK";
	}

}
