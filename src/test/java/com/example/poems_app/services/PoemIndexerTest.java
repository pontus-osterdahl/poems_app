package com.example.poems_app.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.poems_app.Poem;

class PoemIndexerTest {
	/**
	static private PoemIndexer poemIndexer;
	static private PoemSearchService poemSearchService = new PoemSearchService();

	@BeforeAll
	static void setup() {
		poemIndexer = new PoemIndexer();
		poemSearchService = new PoemSearchService();
	}

	@AfterEach
	void removeDocument() {
		poemIndexer.removeById(9999);
	}

	@Test
	void shouldIndexPoem() throws SolrServerException, IOException {

		Poem poem = new Poem();
		poem.setId(9999);
		poem.setText("test_test");
		poem.setTitle("test_test_title");

		poemIndexer.index(poem);

		Poem retrievedPoem = poemSearchService.getByid(9999);
		assertTrue(poem.equals(retrievedPoem));
	}

	@Test
	void shouldRemoveIndexFromPoem() throws SolrServerException, IOException {
		Poem poem = new Poem();
		poem.setId(9999);
		poem.setText("test_test");
		poem.setTitle("test_test_title");

		poemIndexer.index(poem);

		poemIndexer.removeById(9999);
		Poem retrievedPoem = poemSearchService.getByid(9999);
		assertTrue(retrievedPoem == null);
	}
	*/
}
