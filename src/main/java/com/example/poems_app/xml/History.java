package com.example.poems_app.xml;

public class History {

	String origin;
	
	String provenance;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	

/**    <history>
        <origin>Created in the <origDate notBefore="1500" notAfter="1600">16th century</origDate> at an <origPlace>unkown</origPlace> location</origin>
        <provenance>"F. I index saec. XVIII; f. II syllabus anno 1550 posterior: Demophili pitagorici | sententiae. | . 1009; notulae A. Mai in ff. 57. 57v. 66; sigillum Bibl. Nat. Paris. in ff. 1 et 106v" - "in dorso tesserae gentiliciae Pii IX et Ioh.-Bapt. Pitra card. bibliothecarii."</provenance>
    </history> */
	
}
