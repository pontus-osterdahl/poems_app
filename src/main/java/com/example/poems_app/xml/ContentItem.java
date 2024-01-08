package com.example.poems_app.xml;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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
