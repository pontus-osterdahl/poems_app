package com.example.poems_app.services;

import java.util.List;
import java.util.Objects;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.xml.Break;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.DescriptiveItem;
import com.example.poems_app.xml.Seg;
import com.example.poems_app.xml.TextWrapper;
import com.example.poems_app.xml.XmlPoem;

@Service
public class SolrDocumentCreator {
	
//	@Autowired
//	XmlPoemService xmlPoemService;
	
	/**
	 * Creates SolrInputDocument for XmlPoem.
	 * 
	 * @param item XmlPoem to be indexed.
	 * @return Document of XmlPoem to be indexed.
	 */
	public SolrInputDocument getSolrInputDocument(XmlPoem item) {
		
        final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("name", item.getName());
		doc.addField("filePath", item.getFilepath());
		
//		List<Seg> segs = xmlPoemService.getContentItemsByXmlPoemId(item.getId());
		
//		for (Seg ci: segs) {
//			SolrInputDocument inputDoc = getSolrInputDoument(ci);
//			doc.addChildDocument(inputDoc);
//		}
		
		return doc;
	}
	
	
	public SolrInputDocument getSolrInputDoument(Seg item) {
        final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("relations", item.getRelations());
		doc.addField("persons", item.getPersons());
		
		if (item instanceof ContentItem) {
			doc.addField("text_id", item.getTextId());
		}

		if (Objects.nonNull(item.getOrig())) {
			String text = ""; 
			for (Break b : item.getOrig().getBreaks()) {
				if (b instanceof TextWrapper ) {
					text += b.getText();
				}
			}
			doc.addField("orig_text",text);
		}
		
		if (Objects.nonNull(item.getReg())) {
			doc.addField("reg_text",item.getReg().getText());
		}
		
		return doc;
	}
	
	/**
	 * Creates SolrInputDocument from ContentItem.
	 * 
	 * @param item ContentItem to be indexed.
	 * @return Document of ContentItem to be indexed.
	 *
	public SolrInputDocument getSolrInputDocument(ContentItem item) {
		
        final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("relations", item.getRelations());
		doc.addField("persons", item.getPersons());
		doc.addField("text_id", item.getTextId());
		if (Objects.nonNull(item.getOrig())) {
			doc.addField("orig_text",item.getOrig().getText());
		}
		
		if (Objects.nonNull(item.getReg())) {
			doc.addField("reg_text",item.getReg().getText());
		}
		
		return doc;
	}
	
    public SolrInputDocument getSolrInputDocument(DescriptiveItem item) {
		
        final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("relations", item.getRelations());
		doc.addField("persons", item.getPersons());
		if (Objects.nonNull(item.getOrig())) {
			doc.addField("orig_text",item.getOrig().getText());
		}
		
		if (Objects.nonNull(item.getReg())) {
			doc.addField("reg_text",item.getReg().getText());
		}
		
		return doc;
	}*/

}
