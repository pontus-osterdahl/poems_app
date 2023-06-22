package com.example.poems_app.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.Indexer;
import com.example.poems_app.xml.XmlPoem;

@Service
public class XmlPoemIndexer implements Indexer<XmlPoem> {

    protected SolrClient client;
	
	public XmlPoemIndexer() {
		client = getSolrClient();
	}
	
	@Autowired
	ContentItemIndexer ciIndexer;
	
	@Override
	public void index(XmlPoem item) {
		
	final SolrInputDocument doc = new SolrInputDocument();
		
		doc.addField("id", item.getId());
		doc.addField("name", item.getName());
		doc.addField("filePath", item.getFilepath());
		
		try {
     		client.add("poems", doc);
	    	client.commit("poems");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ciIndexer.indexAll(item.getContentItems());
	}

	@Override
	public void indexAll(Iterable<XmlPoem> items) {
		for (XmlPoem poem : items) {
			index(poem);
		}
	}

	@Override
	public void removeItem(XmlPoem item) throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		
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
