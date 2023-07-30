package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class InnerText {
	
	private String xmlId;

	public String getXmlId() {
		return xmlId;
	}

	public void setXmlId(String xmlId) {
		this.xmlId = xmlId;
	}
	
	@OneToOne
	private Front front;
	
	@OneToOne
	private Body body;

	public Front getFront() {
		return front;
	}

	public void setFront(Front front) {
		this.front = front;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
