package com.example.poems_app;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

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
