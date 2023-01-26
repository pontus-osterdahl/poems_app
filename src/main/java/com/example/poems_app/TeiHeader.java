package com.example.poems_app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="teiHeader")
public class TeiHeader {
	
	private FileDesc fileDesc;
	
	public void setFileDesc(FileDesc fileDesc) {
		this.fileDesc = fileDesc;
	}
	
	@XmlElement(name="fileDesc")
	public FileDesc getFileDesc() {
		return this.fileDesc;
	}

}
