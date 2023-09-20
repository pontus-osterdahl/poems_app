package com.example.poems_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poems_app.repositories.SegmentRepository;
import com.example.poems_app.xml.Seg;

@Service
public class SegmentService {
	
	@Autowired
    private SegmentRepository segmentRepository;
	
	public Seg getSegById(int id) {
		return segmentRepository.findById(id).orElseThrow();
	}
	
	public Iterable<Seg> getAllSegs() {
		return segmentRepository.findAll();
	}
}
