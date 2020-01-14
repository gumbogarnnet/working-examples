package com.learning.file.upload.with.mysql;

import com.learning.file.upload.with.mysql.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileUploadWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadWithMysqlApplication.class, args);
	}
        
        @Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
