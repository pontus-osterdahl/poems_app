package com.example.poems_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.poems_app.CriticalApparatus;
import com.example.poems_app.CriticalApparatusEntry;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Reg;

public class CriticalApparatusService {

	@Autowired
	private XmlPoemService xmlPoemService;

	@Autowired
	private CriticalApparatusGenerator generator;

	public CriticalApparatus getCriticalApparatus(ContentItem ci) {

		
		
		List<String> relations = ci.getRelations();
		List<ContentItem> cis = new ArrayList<ContentItem>();

		for (String s : relations) {
			try {
				ContentItem tmpCi = xmlPoemService.getContentItemByTextId(s);
				cis.add(tmpCi);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<Reg> regs = cis.stream().map(c -> c.getChoice().getReg()).collect(Collectors.toList());

		return generator.generateCriticalApparatus(ci.getChoice().getReg(), regs);
		
		
		
	}


}
