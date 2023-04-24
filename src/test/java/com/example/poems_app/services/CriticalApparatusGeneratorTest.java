package com.example.poems_app.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;

import com.example.poems_app.CriticalApparatus;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.ContentItemChoice;
import com.example.poems_app.xml.Reg;
import com.example.poems_app.xml.XmlPoem;

class CriticalApparatusGeneratorTest {

	CriticalApparatusGenerator generator = new CriticalApparatusGenerator();

	@Test
	void generateCriticalApparatus() {
		ContentItemChoice cic1 = new ContentItemChoice();
		ContentItemChoice cic2 = new ContentItemChoice();

		ContentItem ci1 = new ContentItem();
		ContentItem ci2 = new ContentItem();

		XmlPoem poem1 = new XmlPoem();
		XmlPoem poem2 = new XmlPoem();

		poem1.setName("M");
		poem2.setName("B");

		ci1.setXmlPoem(poem1);
		ci2.setXmlPoem(poem2);

		cic1.setContentItem(ci1);
		cic2.setContentItem(ci2);

		Reg reg = new Reg();
		reg.setText("Jag är ett test");
		reg.setContentItemChoice(cic1);
		Reg reg2 = new Reg();
		reg2.setText("Jag är ett nytt test");
		reg2.setContentItemChoice(cic2);

		List<Reg> regs = new ArrayList<Reg>();
		regs.add(reg2);

		CriticalApparatus ca = generator.generateCriticalApparatus(reg, regs);
		System.out.println(ca.toString());
		assertTrue(ca.toString().equals("test : nytt B"));
	}

}
