package com.example.poems_app.xml;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ManuscriptDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany
	private List<MsItemStruct> msContent;
	
	@OneToOne
	private MsIdentifier msIdentifier;
    
	@OneToOne
	private History history;
    
    @OneToOne
    private Additional additional;
    
    @OneToOne
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
 
}
