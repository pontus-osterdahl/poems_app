package com.example.poems_app.xml;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TeiHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private FileDesc fileDescription;

	public FileDesc getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(FileDesc fileDescription) {
		this.fileDescription = fileDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
