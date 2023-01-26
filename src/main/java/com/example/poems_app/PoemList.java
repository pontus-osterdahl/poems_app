package com.example.poems_app;

import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "poems")
@XmlAccessorType(XmlAccessType.FIELD)
public class PoemList {
	@XmlElement(name = "poem")
	private List<Poem> poems = null;

	public List<Poem> getPoems() {
		return this.poems;
	}
	
	public void setPoems(List<Poem> poems) {
		this.poems = poems;
	}
}
