package com.example.poems_app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

	@XmlRootElement(name="seg")
	public class Fragment {

		private List<String> text;
//		private List<PersName> personalNames = ;
/**		private String title;
		private String type;*/
		private String personalName;
		
		@JsonProperty("identifier")
		private String id;
		
		@XmlAttribute(name="id",namespace="http://www.w3.org/XML/1998/namespace")
		public String getIdentifier() {
			return this.id;
		}
		
		/**@XmlElement(name="persName")
		public PersName getPersName() {
			return this.persName;
		}*/
		
		public void setIdentifier(String id) {
			this.id = id;
		}
		/**
		@XmlAttribute(name="type")
		public void setType(String value) {
			this.type = value;
		}*/
		/**
		@XmlElement(name="title")
		public void setTitle(String value) {
			this.title = value;
		}*/
		
		
		public void setPersonalNames(String personalName) {
			personalName = personalName;
		}
		
		@XmlElement(name="persName")
		public String getpersNames() {
			return this.personalName;
		}
		
		public void setText(List<String> value) {
			this.text = value;
		}
		
		@XmlMixed
		public List<String> getText() {
			return this.text;
		}
}
