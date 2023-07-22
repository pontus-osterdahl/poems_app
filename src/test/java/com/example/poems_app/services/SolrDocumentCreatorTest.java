package com.example.poems_app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.solr.common.SolrInputDocument;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Orig;
import com.example.poems_app.xml.Reg;
import com.example.poems_app.xml.XmlPoem;


class SolrDocumentCreatorTest {


	SolrDocumentCreator documentCreator = new SolrDocumentCreator();
	
	@Test
	void shouldCreateXmlPoemDocument() {
		XmlPoem xmlPoem = new XmlPoem();
		xmlPoem.setFilepath("TEST PATH");
		xmlPoem.setId(1);
		xmlPoem.setName("TEST POEM");
		xmlPoem.setContentItems(new HashSet<ContentItem>());
		SolrInputDocument doc = documentCreator.getSolrInputDocument(xmlPoem);	
		assertEquals(doc.jsonStr().replaceAll("\\s", ""),"{\"id\":\"id=1\",\"name\":\"name=TESTPOEM\",\"filePath\":\"filePath=TESTPATH\"}".replaceAll("\\s", ""));
	}
	
	@Test
	void shouldCreateContentItemDocument() {
		XmlPoem xmlPoem = new XmlPoem();
		ContentItem contentItem = new ContentItem();
		contentItem.setId(1);
		contentItem.setTextId("Aristophanes_1");
		contentItem.setRelations(List.of("Aristophanes_2", "Aristohanes_3"));
		Orig orig = new Orig();
		orig.setText("TEST TEXT");
		Reg reg = new Reg();
		reg.setText("TEST TEXT");
		contentItem.setOrig(orig);
		contentItem.setReg(reg);
		contentItem.setId(1);
		contentItem.setXmlPoem(xmlPoem);
		SolrInputDocument doc = documentCreator.getSolrInputDocument(contentItem);
		assertEquals(doc.jsonStr().replaceAll("\\s",  ""),"{\"id\":\"id=1\",\"xmlpoem_id\":\"xmlpoem_id=0\",\"relations\":\"relations=[Aristophanes_2, Aristohanes_3]\",\"text_id\":\"text_id=Aristophanes_1\",\"orig_text\":\"orig_text=TEST TEXT\",\"reg_text\":\"reg_text=TEST TEXT\"}".replaceAll("\\s", ""));
	}

}
