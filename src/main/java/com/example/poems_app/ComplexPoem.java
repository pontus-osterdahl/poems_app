package com.example.poems_app;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.solr.common.annotation.JsonProperty;

	@XmlSeeAlso({Lemma.class, Word.class,Diacritic.class,PlaceName.class})
	public class ComplexPoem {
    	
        @JsonProperty("lemma")
        private List<Lemma> lemma;
		
		@XmlElements({
			@XmlElement(name="w",type=Word.class),
			@XmlElement(name="d",type=Diacritic.class),
			@XmlElement(name="p",type=PlaceName.class),
		})
		public List<Lemma> getLemma() {
			return this.lemma;
		}
		
		public void setLemma(List<Lemma> lemma) {
			this.lemma = lemma;
		}
		
		@Override
		public String toString() {
			String string = lemma.stream()
					.map(x -> x.getContent())
					.reduce("", (a, b) -> a + b);
			return string;
		}
	}
