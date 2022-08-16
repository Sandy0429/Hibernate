package com.sandhya.springdata.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandhya.springdata.files.entities.Image;
import com.sandhya.springdata.files.repos.ImageRepository;

@SpringBootTest
class FileDataApplicationTests {

	@Autowired
	ImageRepository repository;

	@Test
	public void testImageSave() throws IOException {

		Image image = new Image();
		image.setId(1L);
		image.setName("Tiger.jpg");

		File file = new File("D:/STS/FileData/image/tigerImage.jpg");

		byte fileContent[] = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);

		inputStream.read(fileContent);

		image.setData(fileContent);
		
		repository.save(image);

		inputStream.close();
		
	}
	
	@Test
	public void testReadImage()throws IOException  {
		Optional<Image> image = repository.findById(1L);
		 File file = new File("D:/STS/FileData/image/downloaded/"+image.get().getName());
		 
		 FileOutputStream fos = new FileOutputStream(file);
		 fos.write(image.get().getData());
		 
		 	 
		 
		 
		 fos.close();		 
		
	}

}
