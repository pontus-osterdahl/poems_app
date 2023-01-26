package com.example.poems_app;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="persName")
public class PersName implements Serializable {
	
	  private static final long serialVersionUID = 1L;
    private String key;
    private String text;
    
    @XmlAttribute(name="key")
    public String getKey() {
    	return this.key;
    }
    
    @XmlValue
    public String getText() {
    	return this.text;
    }
    
}
