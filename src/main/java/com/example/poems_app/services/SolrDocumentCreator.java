package com.example.poems_app.services;

import java.util.Objects;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

@Service
public class SolrDocumentCreator {
	
	/**
	 * Creates SolrInputDocument form XmlPoem.
	 * 
	 * @param item XmlPoem to be indexed.
	 * @return Document of XmlPoem to be indexed.
	 */
	public SolrInputDocument getSolrInputDocument(XmlPoem item) {
		
        final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("name", item.getName());
		doc.addField("filePath", item.getFilepath());
		
		/**for (ContentItem ci: item.getContentItems()) {
			doc.addChildDocument(getSolrInputDocument(ci));
			doc.addChildDocument(doc);
		}*/
		
		return doc;
	}
	
	/**
	 * Creates SolrInputDocument from ContentItem.
	 * 
	 * @param item ContentItem to be indexed.
	 * @return Document of ContentItem to be indexed.
	 */
	public SolrInputDocument getSolrInputDocument(ContentItem item) {
		
        final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		/**doc.addField("xmlpoem_id", item.getXmlPoem().getId());*/
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

}
