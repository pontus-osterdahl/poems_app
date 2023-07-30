package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Group {
	@OneToOne
    private InnerText text;

	public InnerText getText() {
		return text;
	}

	public void setText(InnerText text) {
		this.text = text;
	}
}
