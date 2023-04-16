package com.example.poems_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CriticalApparatusEntry {

	private String lemma;
	
	private Map<String,String> variants;
	
	public CriticalApparatusEntry(String lemma) {
		this.lemma = lemma;
		this.variants = new HashMap<String,String>();
	}
	
	public CriticalApparatusEntry() {
		this("");
		
	}
	
	public void addVariant(String source, String variant) {
		variants.put(source, variant);
	}



	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}



	public Map<String, String> getVariants() {
		return variants;
	}



	public void setVariants(Map<String, String> variants) {
		this.variants = variants;
	}
	
	
}
