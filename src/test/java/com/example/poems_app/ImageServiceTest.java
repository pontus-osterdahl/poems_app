package com.example.poems_app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ImageServiceTest {

	private ImageService imageService;
	private final String PATH = "src/main/resources/tmp.tmp";

	@AfterEach
	void cleanUp() throws IOException {
		FileUtils.delete(new File(PATH));
	}

	@Test
	void test() throws IOException {
		imageService = new ImageService();
		MockMultipartFile mockFile = new MockMultipartFile("tmp.tmp", "Hello World".getBytes());
		imageService.saveImageOnServer(mockFile, PATH);
		assertEquals(FileUtils.readFileToString(new File(PATH), "UTF-8"), "Hello World");
	}

}
