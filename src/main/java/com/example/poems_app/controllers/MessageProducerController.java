package com.example.poems_app.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageProducerController {

    private static final String TEST_TOPIC = "quickstart-events";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageProducerController(@Qualifier("kafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send-message")
    @CrossOrigin
    public void sendMessage(@RequestParam String messageRequest) {
        kafkaTemplate.send(TEST_TOPIC, messageRequest);
    }

}