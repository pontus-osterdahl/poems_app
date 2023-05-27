package com.example.poems_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.poems_app.CriticalApparatus;
import com.example.poems_app.CriticalApparatusEntry;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Reg;

public class CriticalApparatusService {

	/**@Autowired
	private ApophthegmTextExtractor apophthegmTextExtractor;

	@Autowired
	private CriticalApparatusGenerator generator;

	public CriticalApparatus getCriticalApparatus(ContentItem ci) throws Exception {

		List<String> relations = ci.getRelations();

		Reg reg = apophthegmTextExtractor.extractApophtegmText(ci.getTextId()).getReg();
		List<Reg> regs = relations.stream().map(c -> {
			try {
				return apophthegmTextExtractor.extractApophtegmText(c).getReg();
			} catch (Exception e) {
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());

		return generator.generateCriticalApparatus(reg, regs);

	}*/

}
