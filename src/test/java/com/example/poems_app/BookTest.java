package com.example.poems_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.Test;

public class BookTest {
	
	@Test
	public void shouldEqual() {
		Book book1 = new Book("The time of my life : an autobiography",
				"Quine, W. V.","0262170035","Cambridge, Mass. : MIT Press", "cop. 1985", "http://libris.kb.se/bib/4739804");
		Book book2 = new Book("The time of my life : an autobiography",
				"Quine, W. V.","0262170035","Cambridge, Mass. : MIT Press", "cop. 1985", "http://libris.kb.se/bib/4739804");
		
		assertEquals(book1, book2);
	}
	
	@Test
	public void shouldNotEqual() {
		Book book1 = new Book("The time of my life : an autobiography",
				"Quine, W. V.","0262170035","Cambridge, Mass. : MIT Press", "cop. 1985", "http://libris.kb.se/bib/4739804");
		Book book2 = new Book("The time of my life : an autobiography",
				"Quine, W. V.","0262170035","Cambridge, Mass. : MIT Press", "cop. 1985", "");
		
		assertNotEquals(book1, book2);
	}
	

}
