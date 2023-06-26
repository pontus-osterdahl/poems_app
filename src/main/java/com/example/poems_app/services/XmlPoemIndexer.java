package com.example.poems_app.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.Indexer;
import com.example.poems_app.xml.ContentItem;
import com.example.poems_app.xml.XmlPoem;

@Service
public class XmlPoemIndexer implements Indexer<XmlPoem> {

    protected SolrClient client;
	
	public XmlPoemIndexer() {
		client = getSolrClient();
	}
	
	@Autowired
	SolrDocumentCreator docCreator;
	
	@Override
	public void index(XmlPoem item) {
		
	    final SolrInputDocument doc = docCreator.getSolrInputDocument(item);
     	try {
     		client.add("poems", doc);
	        client.commit("poems");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void indexAll(Iterable<XmlPoem> items) {
		for (XmlPoem poem : items) {
			index(poem);
		}
	}

	@Override
	public void removeItem(XmlPoem item) throws SolrServerException, IOException {
		try {
			client.deleteByQuery("poems", "id:" + item.getId());
			client.commit("poems");
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clearIndex() throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected SolrClient getSolrClient() {
		HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr").build();
		
		return solr;
	}
	
}
