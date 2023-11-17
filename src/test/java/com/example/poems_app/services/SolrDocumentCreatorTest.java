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

import com.example.poems_app.xml.AuthorSection;
import com.example.poems_app.xml.Body;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.Letter;
import com.example.poems_app.xml.Orig;
import com.example.poems_app.xml.Part;
import com.example.poems_app.xml.Reg;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.Text;
import com.example.poems_app.xml.XmlPoem;

//@SpringBootTest
class SolrDocumentCreatorTest {

/**	SolrDocumentCreator documentCreator;
	
	@Test
	void shouldCreateXmlPoemDocument() {
		XmlPoem xmlPoem = new XmlPoem();
		xmlPoem.setFilepath("TEST PATH");
		xmlPoem.setId(1);
		xmlPoem.setName("TEST POEM");
		Text text = new Text();
		TextGroup textGroup = new TextGroup();
		InnerText innerText = new InnerText();
		Body body = new Body();
		List<Part> parts = new ArrayList();
		Part part = new Part();
		List<Letter> letters = new ArrayList();
		Letter letter = new Letter();
		AuthorSection author = new AuthorSection();
		List<AuthorSection> authors = new ArrayList();
		authors.add(author);
		List<Seg> segs = new ArrayList();
		Seg seg = new ContentItem();
		seg.setId(9999);
		seg.setTextId("hallo");
		Set<String> persons = new HashSet();
		Set<String> placenames = new HashSet();
		seg.setPersons(persons);
		seg.setPlacenames(placenames);
		author.setSegments(segs);
		letter.setAuthors(authors);
		letters.add(letter);
		part.setLetters(letters);
		parts.add(part);
		body.setParts(parts);
		innerText.setBody(body);
		textGroup.setInnerText(innerText);
		text.setGroup(textGroup);
		xmlPoem.setText(text);
		SolrInputDocument doc = documentCreator.getSolrInputDocument(xmlPoem);	
		assertEquals(doc.jsonStr().replaceAll("\\s", ""),"{\"id\":\"id=1\",\"name\":\"name=TESTPOEM\",\"filePath\":\"filePath=TESTPATH\"}".replaceAll("\\s", ""));
	}
	
	@Test
	void shouldCreateContentItemDocument() {
		Seg contentItem = new ContentItem();
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
		SolrInputDocument doc = documentCreator.getSolrInputDoument(contentItem);
		assertEquals(doc.jsonStr().replaceAll("\\s",  ""),"{\"id\":\"id=1\",\"relations\":\"relations=[Aristophanes_2, Aristohanes_3]\",\"persons\":\"persons=[]\",\"text_id\":\"text_id=Aristophanes_1\",\"orig_text\":\"orig_text=TEST TEXT\",\"reg_text\":\"reg_text=TEST TEXT\"}".replaceAll("\\s", ""));
	}
*/
}
