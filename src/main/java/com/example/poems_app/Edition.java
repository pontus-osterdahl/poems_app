package com.example.poems_app;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Edition {

	@JsonProperty("title")
	private String title;
	private String titlePart;
	@JsonProperty("id")
	private String id;
	
	public String getTitle() {
		return this.title;
	}
	
	@JsonProperty("segments")
	private List<Segment> segments;
	
	public Edition(String title, String id, List<Segment> segments) {
		this.title = title;
		this.id = id;
		this.segments = segments;
	}
		
}

class FragmentCollection {
	private List<Apophthegm> apophthegms;
}
