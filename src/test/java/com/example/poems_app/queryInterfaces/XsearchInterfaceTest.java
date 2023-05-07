package com.example.poems_app.queryInterfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.poems_app.BibItem;
import com.example.poems_app.BibItemSource;
import com.example.poems_app.Book;
import com.example.poems_app.ImportService;
import com.example.poems_app.searchinterfaces.XsearchInterface;

public class XsearchInterfaceTest {	
	
	@Test
	public void shouldImportBibItem() throws IOException {
		
		BibItemSource bibSource = new BibItemSource();
		bibSource.setHost("http://libris.kb.se/xsearch?query=");
		bibSource.setInterfaceType("Xsearch");

		String query = "W.V.+Quine";
		
		ImportService importService = new ImportService();
		
		XsearchInterface xsearch = new XsearchInterface();
		URL url = mock(URL.class);
		
		when(url.toString()).thenReturn("{\"xsearch\": {\r\n" + 
				"\"from\": 1,\r\n" + 
				"\"to\": 10,\r\n" + 
				"\"records\": 182,\r\n" + 
				"\"list\": [\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/6131039\",\r\n" + 
				"\"title\": \"Essays on the philosophy of W.V. Quine\",\r\n" + 
				"\"isbn\": \"0855270187\",\r\n" + 
				"\"type\": \"book\",\r\n" + 
				"\"publisher\": \"Hassocks, Sussex : Harvester P\",\r\n" + 
				"\"date\": \"cop. 1979\",\r\n" + 
				"\"language\": \"eng\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/4739804\",\r\n" + 
				"\"title\": \"The time of my life : an autobiography\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"isbn\": \"0262170035\",\r\n" + 
				"\"type\": \"book\",\r\n" + 
				"\"publisher\": \"Cambridge, Mass. : MIT Press\",\r\n" + 
				"\"date\": \"cop. 1985\",\r\n" + 
				"\"language\": \"eng\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/5704464\",\r\n" + 
				"\"title\": \"Essays on the philosophy of W.V. Quine\",\r\n" + 
				"\"isbn\": \"0806115165\",\r\n" + 
				"\"type\": \"book\",\r\n" + 
				"\"publisher\": \"Norman : Univ. of Oklahoma P\",\r\n" + 
				"\"date\": \"cop. 1979\",\r\n" + 
				"\"language\": \"eng\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/11216457\",\r\n" + 
				"\"title\": \"Quine in dialogue\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"isbn\": [\r\n" + 
				"\"9780674030831\",\r\n" + 
				"\"0674030834\"\r\n" + 
				"],\r\n" + 
				"\"type\": \"book\",\r\n" + 
				"\"publisher\": \"Cambridge, Mass. Harvard University Press\",\r\n" + 
				"\"date\": \"2008\",\r\n" + 
				"\"language\": \"eng\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/2025932\",\r\n" + 
				"\"title\": \"In conversation W. V. Quine. [Videoupptagning]\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"type\": \"moving image\",\r\n" + 
				"\"publisher\": \"London : Philosophy International\",\r\n" + 
				"\"date\": \"1994\",\r\n" + 
				"\"language\": \"eng\",\r\n" + 
				"\"description\": \"Huvudpost (flerbandsverk)\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/2025939\",\r\n" + 
				"\"title\": \"In conversation W. V. Quine [Videoupptagning]\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"type\": \"moving image\",\r\n" + 
				"\"publisher\": \"London : Philosophy International\",\r\n" + 
				"\"date\": \"1994\",\r\n" + 
				"\"language\": \"eng\",\r\n" + 
				"\"relation\": \"In conversation W. V. Quine : [Videoupptagning]\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/2025937\",\r\n" + 
				"\"title\": \"In conversation W. V. Quine [Videoupptagning]\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"type\": \"moving image\",\r\n" + 
				"\"publisher\": \"London : Philosophy International\",\r\n" + 
				"\"date\": \"1994\",\r\n" + 
				"\"language\": \"eng\",\r\n" + 
				"\"relation\": \"In conversation W. V. Quine : [Videoupptagning]\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/2025936\",\r\n" + 
				"\"title\": \"In conversation W. V. Quine [Videoupptagning]\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"type\": \"moving image\",\r\n" + 
				"\"publisher\": \"London : Philosophy International\",\r\n" + 
				"\"date\": \"1994\",\r\n" + 
				"\"language\": \"eng\",\r\n" + 
				"\"relation\": \"In conversation W. V. Quine : [Videoupptagning]\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/2025935\",\r\n" + 
				"\"title\": \"In conversation W. V. Quine [Videoupptagning]\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"type\": \"moving image\",\r\n" + 
				"\"publisher\": \"London : Philosophy International\",\r\n" + 
				"\"date\": \"1994\",\r\n" + 
				"\"language\": \"eng\",\r\n" + 
				"\"relation\": \"In conversation W. V. Quine : [Videoupptagning]\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"identifier\": \"http://libris.kb.se/bib/2025934\",\r\n" + 
				"\"title\": \"In conversation W. V. Quine [Videoupptagning]\",\r\n" + 
				"\"creator\": \"Quine, W. V.\",\r\n" + 
				"\"type\": \"moving image\",\r\n" + 
				"\"publisher\": \"London : Philosophy International\",\r\n" + 
				"\"date\": \"1994\",\r\n" + 
				"\"language\": \"eng\",\r\n" + 
				"\"relation\": \"In conversation W. V. Quine : [Videoupptagning]\"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}}");
		
		BibItem bibItem = new Book("The time of my life : an autobiography",
				"Quine, W. V.","0262170035","Cambridge, Mass. : MIT Press", "cop. 1985", "http://libris.kb.se/bib/4739804");
		List<BibItem> list = xsearch.performQuery(url);

		assertEquals(bibItem,list.get(1));

	}
}
