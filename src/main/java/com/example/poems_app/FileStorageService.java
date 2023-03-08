package com.example.poems_app;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

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
	 * @return Destination of saved image. Null if image could not be saved.
	 * @throws IOException
	 */
	public String saveImageOnServer(MultipartFile image, String path) {
		try {
		    File file = new File(path);
		    image.transferTo(file);
		    return path;
		}
		catch (IOException e) {
		    return null;	
		}
	}
	
}
