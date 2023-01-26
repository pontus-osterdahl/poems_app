package com.example.poems_app;

import java.util.List;

public class EditionGenerator {

    public static Edition generateEdition(TeiRepresentation tei) {
    	String title = tei.getTeiHeader().getFileDesc().getTitleStmt().getTitle();
    	String id = tei.getOuterText().getGroup().getText().getId();
    	List<Segment> segments = tei.getOuterText().getGroup().getText().getBody().getSegmentList().getSegments();
    	
    	List<FragmentCollection> list;
    	return new Edition(title, id, segments);
    }
	
}
