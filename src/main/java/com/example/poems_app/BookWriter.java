package com.example.poems_app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class BookWriter {

	public BookWriter() {
		
	}
	
	public String writePoems(Iterable<Poem> poems) {

		String output = null;
		for(Poem p : poems)
		{
			output += generatePoemString(p);
		}
		
		return output;
	 
    }
	
	
	private String generatePoemString(Poem poem) {
		
		String output = "";
    	String pTitle = poem.getTitle();
    	String pText = poem.getText();
    	if(!(pTitle == null || pTitle.length() == 0)) {
    	    
				output += pTitle;
	    	    output  += "\n";
        }
    	else {
    		output += "Title unknown";
    		output += "\n";
    	}
    	if(!(pText == null || pText.length() == 0)) {
    		output += pText;
    		output += "\n";
    	}	
    	
    	return output;
	}
	
	public String writePoem(Poem poem) {
		   return generatePoemString(poem);
	}
}
