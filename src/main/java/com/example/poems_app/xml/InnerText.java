package com.example.poems_app.xml;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InnerText {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String xmlId;

	public String getXmlId() {
		return xmlId;
	}

	public void setXmlId(String xmlId) {
		this.xmlId = xmlId;
	}
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Front front;
	
	@OneToOne(cascade = {CascadeType.ALL})
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
