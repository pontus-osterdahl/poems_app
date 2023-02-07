package com.example.poems_app;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	/**
	 * Method to save an image to a specified location  
	 * @param image MultipartFile to be saved
	 * @param path Path to save file to
	 * @throws IOException
	 */
	public void saveImageOnServer(MultipartFile image, String path) throws IOException {
		File file = new File(path);
		image.transferTo(file);
	}
	
}
