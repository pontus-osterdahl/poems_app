package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class TitlePage {

	@OneToOne
	private DocTitle docTitle;
	
}
