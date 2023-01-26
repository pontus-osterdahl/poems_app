package com.example.poems_app;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fileDesc")
public class FileDesc {
    
    private TitleStmt titleStmt;

    public void setTitleStmt(TitleStmt titleStmt) {
    	this.titleStmt = titleStmt;
    }
    
    @XmlElement(name="titleStmt")
    public TitleStmt getTitleStmt() {
    	return this.titleStmt;
    }
}
