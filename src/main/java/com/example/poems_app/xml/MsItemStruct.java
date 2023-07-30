package com.example.poems_app.xml;

public class MsItemStruct {

    
    public MsItemStruct(Locus locus, String author, String title, String note, String textLang) {
		this.locus = locus;
		this.author = author;
		this.title = title;
		this.note = note;
		this.textLang = textLang;
	}
	private Locus locus;
    private String author;
    private String title;
    private String note;
    private String textLang;
	
}
