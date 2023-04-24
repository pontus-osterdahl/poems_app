package com.example.poems_app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.poems_app.CriticalApparatus;
import com.example.poems_app.CriticalApparatusEntry;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Reg;

@Service
public class CriticalApparatusGenerator {


class Variant {
	
	String name;
	
	String[] words;
	
	Variant(String name, String[] words) {
		this.name = name;
		this.words = words;
	}
	
	int getSize() {
	    return this.words.length;
	}
	
	String getWord(int i) {
		return this.words[i];
	}
	
	String getName() {
		return this.name;
	}
	
}
	
	public CriticalApparatus generateCriticalApparatus(Reg reg, List<Reg> regs) {
			
			CriticalApparatus cas = new CriticalApparatus();
			
			List<Variant> variants = new ArrayList<Variant>();

			for (Reg r : regs) {
			    String[] words = r.getText().split(" ");
			    String name = r.getContentItemChoice().getContentItem().getXmlPoem().getName();
			    variants.add(new Variant(name,words));
			}
				
		    String[] words = reg.getText().split(" ");
		    
		    for (int i = 0; i < words.length; i++) {
		    	CriticalApparatusEntry cae = new CriticalApparatusEntry();
		    	Map<String,String> diffs = new HashMap<String,String>();
		    	for (Variant v : variants) {
		    	    if (v.getSize() > i) {
		    	    	if (!v.getWord(i).equals(words[i])) {
		    	            diffs.put(v.getName(), v.getWord(i));
		    	        }
		    	    }
		    	}
		    	
		    	if (diffs.size() > 0) {
		    		cae.setLemma(words[i]);
		    		cae.setVariants(diffs);
		    	}
		    	
		    	cas.addEntry(cae);
			}
			
			return cas;
			
	}
	
}
