package com.example.poems_app;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TEI") 
public class TeiRepresentation {

	private TeiHeader teiHeader;
	
	private OuterText text;
	
	public void setOuterText(OuterText text) {
		this.text = text;
	}
	
	@XmlElement(name="text")
	public OuterText getOuterText() {
		return this.text;
	}
	
	public void setTeiHeader(TeiHeader teiHeader) {
		this.teiHeader = teiHeader;
	}
	
	@XmlElement(name="teiHeader")
	public TeiHeader getTeiHeader() {
		return this.teiHeader;
	}
	
}
