package com.example.poems_app.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.poems_app.*;
import com.example.poems_app.queryExecutors.BibItemQueryExecutor;
import com.example.poems_app.queryExecutors.LibrisQueryExecutor;
import com.example.poems_app.queryModules.LibrisQueryModule;
import com.example.poems_app.queryModules.QueryModule;
import com.example.poems_app.services.Importer;

public class ImporterTest {

	@Test
	public void shouldImportItem() throws IOException {
		QueryModule queryMod = new LibrisQueryModule();
		queryMod.setFormat("json");
		BibItemReader bibItemReader = new LibrisReader();
		BibItemQueryExecutor queryExecutor = new LibrisQueryExecutor();
		Importer importer = new Importer(queryMod,queryExecutor);
		BibItem bibItem = new Book("The time of my life : an autobiography",
				"Quine, W. V.","0262170035","Cambridge, Mass. : MIT Press", "cop. 1985", "http://libris.kb.se/bib/4739804");
		List<BibItem> list = importer.importItems("W.V.+Quine");

		System.out.println(list.get(1).getTitle());
		assertTrue(bibItem.getTitle().equals(list.get(1).getTitle()));		
	}
}
