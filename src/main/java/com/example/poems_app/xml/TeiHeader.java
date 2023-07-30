package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class TeiHeader {

	@OneToOne
	private FileDesc fileDescription;

	public FileDesc getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(FileDesc fileDescription) {
		this.fileDescription = fileDescription;
	}

	
}
