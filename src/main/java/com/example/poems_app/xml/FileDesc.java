package com.example.poems_app.xml;

public class FileDesc {

	private TitleStatement titleStatement;
	private String publicationStatement;
	private SourceDescription sourceDescription;
	public TitleStatement getTitleStatement() {
		return titleStatement;
	}
	public void setTitleStatement(TitleStatement titleStatement) {
		this.titleStatement = titleStatement;
	}
	public String getPublicationStatement() {
		return publicationStatement;
	}
	public void setPublicationStatement(String publicationStatement) {
		this.publicationStatement = publicationStatement;
	}
	public SourceDescription getSourceDescription() {
		return sourceDescription;
	}
	public void setSourceDescription(SourceDescription sourceDescription) {
		this.sourceDescription = sourceDescription;
	}
	
}
