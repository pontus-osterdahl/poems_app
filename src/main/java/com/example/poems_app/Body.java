package com.example.poems_app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="body")
public class Body {
	

    private SegmentList segmentList;

	@XmlElement(name="div")
	public SegmentList getSegmentList() {
		return segmentList;
	}
	
	public void setSegmentList(SegmentList segmentList) {
		this.segmentList = segmentList;
	}
	
	
}
