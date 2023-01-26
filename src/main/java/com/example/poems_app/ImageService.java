package com.example.poems_app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imgRepository;
	
	public Optional<Image> getImageById(int id) {
	    return imgRepository.findById(id);	
	}
	
	public Image saveImage(Image image) {
		return imgRepository.save(image);
	}
	
}
