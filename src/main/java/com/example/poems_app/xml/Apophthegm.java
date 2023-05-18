package com.example.poems_app.xml;

import java.util.List;

public class Apophthegm {
	private Orig orig;
	
	private Reg reg;
	
	private String textId;
	
	private List<String> relations;

	public Orig getOrig() {
		return orig;
	}

	public void setOrig(Orig orig) {
		this.orig = orig;
	}

	public Reg getReg() {
		return reg;
	}

	public void setReg(Reg reg) {
		this.reg = reg;
	}
	
	public String getTextId() {
		return textId;
	}

	public void setTextId(String textId) {
		this.textId = textId;
	}
	
	public List<String> getRelations() {
		return this.relations;
	}

	public void setRelations(List<String> relations) {
		this.relations = relations;
	}

}
