package com.fastcode.email.emailbuilder.emailconverter.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.annotation.PostConstruct;

import com.fastcode.email.EmailPropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class AppLifeCycle {

	@Autowired
	EmailPropertiesConfiguration env;
	@PostConstruct
	public void init() throws IOException {
		File file = new File(env.getMjmlFileBaseDir());
		if (!file.exists()) {
			file.mkdirs();
		}

		ClassPathResource resourceMailTem1 = new ClassPathResource("templates/emailTemplate/basicTemp.txt");
		ClassPathResource resourceMailTemp2 = new ClassPathResource("templates/emailTemplate/sectionTemp.txt");
		if (new File(env.getMjmlFileBaseDir()).exists()) {

			if (resourceMailTem1.exists()) {
				try {
					InputStream inputStream = resourceMailTem1.getInputStream();
					Path targetPath = Paths.get(env.getMjmlFileBaseDir()).resolve(resourceMailTem1.getFilename());
					Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					throw new IOException("Error : " + e.getMessage());
				}
			}
			
			if (resourceMailTemp2.exists()) {
				try {
					InputStream inputStream = resourceMailTemp2.getInputStream();
					Path targetPath = Paths.get(env.getMjmlFileBaseDir()).resolve(resourceMailTemp2.getFilename());
					Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					throw new IOException("Error : " + e.getMessage());
				}
			}
		}
	}

	public void storeFile(File file, String destinationFilePath) throws IOException {
		Path path = Paths.get(destinationFilePath).resolve(file.getName());
		Files.copy(file.toPath(), path, StandardCopyOption.REPLACE_EXISTING);
	}
}

