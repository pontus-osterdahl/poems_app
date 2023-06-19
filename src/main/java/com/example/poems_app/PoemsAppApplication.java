package com.example.poems_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
public class PoemsAppApplication {

    private static final String TEST_TOPIC = "quickstart-events";
    private static final String TEST_GROUP = "test-group";
	
	public static void main(String[] args) {
		SpringApplication.run(PoemsAppApplication.class, args);
	}
	
}
