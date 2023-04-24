package com.example.poems_app;

import java.util.ArrayList;
import java.util.Map;

public class CriticalApparatus {

	private ArrayList<CriticalApparatusEntry> entries;
	
	public CriticalApparatus() {
		entries = new ArrayList<>();
	}
	
	public void addEntry(CriticalApparatusEntry cae) {
		entries.add(cae);
	}
	
	
	@Override
	public String toString() {
		String output = "";
		for(CriticalApparatusEntry e : entries) {
			output+= e.getLemma();
			Map<String,String> maps = e.getVariants();
			for (Map.Entry<String,String> entry : maps.entrySet()) {
				output += " : " + entry.getValue() + " " + entry.getKey();
			}
		}
		
		return output;
	}
	
}
