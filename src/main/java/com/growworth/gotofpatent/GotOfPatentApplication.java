package com.growworth.gotofpatent;

import com.growworth.gotofpatent.storage.StorageProperties;
import com.growworth.gotofpatent.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class GotOfPatentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotOfPatentApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
