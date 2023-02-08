package com.example.poems_app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@CrossOrigin
	@GetMapping("/images/getImage/{id}")
	public Optional<Image> getImage(@PathVariable int id)
	{
		return imageService.getImageById(id);
	}
	
	@CrossOrigin
	@GetMapping(
			value = "/images/getImageFile/{id}",
			produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageFile(@PathVariable int id) throws IOException
	{
		Optional<Image> img = imageService.getImageById(id);
		
		return img.map(i -> getClass().getResourceAsStream(i.getFilepath())).		
		map(this::toByteArray).
		orElse(null);	
	}
	
	private byte[] toByteArray(InputStream is) {
		try {
			return IOUtils.toByteArray(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@CrossOrigin
	@PostMapping("/images/addImage")
	public Image saveImage(@RequestBody Image img)
	{
		return imageService.saveImage(img);
	}
	
	
	//Add MULTIPARTFILE
	@CrossOrigin
	@PostMapping("/images/addImageFile")
	public Image saveImageToServer(@RequestBody Image img)
	{
		return imageService.saveImageToServer(img);
	}
	
	
}
