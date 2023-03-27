package com.example.poems_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
public class PoemsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoemsAppApplication.class, args);
	}

}
