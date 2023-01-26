package com.example.poems_app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="group")
public class Group {
    private Text text;
    
    @XmlElement(name="text")
    public Text getText() {
    	return this.text;
    }
    
    public void setText(Text text) {
    	this.text = text;
    }
}
