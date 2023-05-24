package com.mhv.springkafka.controller;

import com.mhv.springkafka.entity.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/api/item/publish")
    public ResponseEntity<String> publishEvent(@RequestBody UserMessage userMessage){
        try {
            kafkaTemplate.send("new-item-available", userMessage.message());
            return new ResponseEntity<>("Event published !!", HttpStatusCode.valueOf(200));
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong on the server !!", HttpStatusCode.valueOf(500));
        }
    }
}
