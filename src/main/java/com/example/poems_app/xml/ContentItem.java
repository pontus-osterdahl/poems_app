package com.example.poems_app.xml;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.solr.common.SolrInputDocument;

import com.example.poems_app.services.SolrDocumentCreator;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ContentItem extends Seg {

	@Column(unique = true)
	private String textId;

	public String getTextId() {
		return this.textId;
	}

	public void setTextId(String textId) {
		this.textId = textId;
	}
}
