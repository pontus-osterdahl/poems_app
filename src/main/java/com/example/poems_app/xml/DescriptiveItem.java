package com.example.poems_app.xml;

import jakarta.persistence.Entity;

import org.apache.solr.common.SolrInputDocument;

import com.example.poems_app.services.SolrDocumentCreator;

@Entity
public class DescriptiveItem extends Seg {

	@Override
	public String getTextId() {
		return "";
	}

	@Override
	public void setTextId(String textId) {
	}

}
