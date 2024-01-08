package com.example.poems_app.xml;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ManuscriptDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<MsItemStruct> msContent;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private MsIdentifier msIdentifier;
    
	@OneToOne(cascade = {CascadeType.ALL})
	private History history;
    
    @OneToOne(cascade = {CascadeType.ALL})
    private Additional additional;
    
    @OneToOne(cascade = {CascadeType.ALL})
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
