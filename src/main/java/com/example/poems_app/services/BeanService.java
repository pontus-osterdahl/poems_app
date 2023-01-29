package com.example.poems_app.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.solr.client.solrj.SolrServerException;

import com.example.poems_app.Poem;

public interface BeanService<T> {

	public Optional<T> getById(int id);
	
	public Iterable<T> getAll();
	
	public Poem add(T item);
	
	public Poem update(T item);
	
	public Iterable<T> addItems(Iterable<T> items);
	
}
