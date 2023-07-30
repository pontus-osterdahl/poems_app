package com.example.poems_app.xml;

import java.util.List;

public class ManuscriptDescription {
	
	private List<MsItemStruct> msContent;
	private MsIdentifier msIdentifier;
    private History history;
    private Additional additional;
    private PhysDescription physicalDescription;
    
	public List<MsItemStruct> getMsContent() {
		return msContent;
	}
	public void setMsContent(List<MsItemStruct> msContent) {
		this.msContent = msContent;
	}
	public MsIdentifier getMsIdentifier() {
		return msIdentifier;
	}
	public void setMsIdentifier(MsIdentifier msIdentifier) {
		this.msIdentifier = msIdentifier;
	}
	public History getHistory() {
		return history;
	}
	public void setHistory(History history) {
		this.history = history;
	}
	public Additional getAdditional() {
		return additional;
	}
	public void setAdditional(Additional additional) {
		this.additional = additional;
	}
	public PhysDescription getPhysicalDescription() {
		return physicalDescription;
	}
	public void setPhysicalDescription(PhysDescription physicalDescription) {
		this.physicalDescription = physicalDescription;
	}
 
}
