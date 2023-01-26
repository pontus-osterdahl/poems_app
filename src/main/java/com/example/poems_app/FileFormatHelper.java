package com.example.poems_app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;

import org.springframework.web.multipart.MultipartFile;

public class FileFormatHelper {
  public static String CSV_TYPE = "text/csv";
  public static String XML_TYPE = "text/xml";
//  static String[] HEADERS = { "Title", "Text" };
  
  public static boolean hasCSVFormat(MultipartFile file) {
	  if(!CSV_TYPE.equals(file.getContentType())) {
		  return false;
	  }
	  
	  return true;
  }
  
  public static boolean hasXMLFormat(MultipartFile file) {
	 /** if(!XML_TYPE.equals(file.getContentType())) {
		  return false;
	  }*/
	  
	  return true;
  }
  
  public static List<Poem> csvToPoems(InputStream is) {
	  List<Poem> poems = new ArrayList<Poem>();
	  try {
		  BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		  Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().parse(fileReader);
		  for (CSVRecord record : records) {
			  
			  String title = record.get("Title");
			  String text = record.get("Text");
			  
			  Poem poem = new Poem();
			  poem.setText(text);
			  poem.setTitle(title);
			  poems.add(poem);
		  }
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
	  return poems;
  }

  public static ComplexPoemOld xmlToComplexPoem(InputStream is) throws JAXBException {
	  
	  JAXBContext jaxbContext 	= JAXBContext.newInstance( ComplexPoem.class,ComplexPoemOld.class, Lemma.class,Word.class,Diacritic.class );
	  Unmarshaller um = jaxbContext.createUnmarshaller();
	  um.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
	  return (ComplexPoemOld) um.unmarshal(is);
	  
  }
  
  public static TeiRepresentation xmlToTeiRepresentation(InputStream is) throws JAXBException {
      JAXBContext jaxbContext 	= JAXBContext.newInstance(TeiRepresentation.class );
	  return (TeiRepresentation) jaxbContext.createUnmarshaller().unmarshal(is);
	  
  }
  
  public static List<Poem> xmlToPoems(InputStream is) throws JAXBException {
	  List<Poem> poems = new ArrayList<Poem>();
	  JAXBContext jaxbContext 	= JAXBContext.newInstance( PoemList.class );
	  
	  PoemList pl = (PoemList) jaxbContext.createUnmarshaller().unmarshal(is);
	  return pl.getPoems();
	  
  }
		  
		  
		  
  
}
