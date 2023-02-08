package com.example.poems_app.queryInterfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.poems_app.BibItem;
import com.example.poems_app.BibItemSource;
import com.example.poems_app.Book;
import com.example.poems_app.ImportService;

public class XsearchInterfaceTest {	
	
	@Test
	public void shouldImportBibItem() {
		
		BibItemSource bibSource = new BibItemSource();
		bibSource.setHost("http://libris.kb.se/xsearch?query=");
		bibSource.setInterfaceType("Xsearch");

		String query = "W.V.+Quine";
		
		ImportService importService = new ImportService();
		
		BibItem bibItem = new Book("The time of my life : an autobiography",
				"Quine, W. V.","0262170035","Cambridge, Mass. : MIT Press", "cop. 1985", "http://libris.kb.se/bib/4739804");
		List<BibItem> list = importService.getBibItems(bibSource, query);

		assertEquals(bibItem,list.get(1));

	}
}
