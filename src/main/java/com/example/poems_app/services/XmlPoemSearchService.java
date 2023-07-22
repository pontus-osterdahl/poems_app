package com.example.poems_app.services;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.SearchRequest;
import com.example.poems_app.SearchType;
import com.example.poems_app.xml.XmlPoem;

@Service
public class XmlPoemSearchService implements SearchService<XmlPoem> {

	@Autowired
	SolrQueryGenerator solrQueryGenerator;

	@Autowired
	XmlPoemService xmlPoemService;

	@Override
	public List<XmlPoem> search(String queryItem) throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<XmlPoem> getAll() throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchType[] getSearchTypes() {
		return new SearchType[] { SearchType.ALL, SearchType.TITLE, SearchType.WORD };
	}

	@Override
	public List<XmlPoem> search(SearchRequest searchRequest) throws SolrServerException, IOException {

		SolrClient solrClient = solrQueryGenerator.getSolrClient();
		SolrQuery query = solrQueryGenerator.getQuery(searchRequest);
		
		QueryResponse response = solrClient.query("poems", query);
		SolrDocumentList docList = response.getResults();

		List<XmlPoem> poems = docList.stream().map(doc -> Integer.valueOf((String) doc.getFirstValue("id")))
				.map(id -> {
					try {
						return xmlPoemService.getXmlPoemById(id);
					} catch (Exception e) {
						return null;
					}
				}).filter(Objects::nonNull).collect(Collectors.toList());
		
		return poems;
	}

}
