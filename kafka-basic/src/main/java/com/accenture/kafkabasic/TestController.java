package com.accenture.kafkabasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class TestController {

    private final Producer producer;

    @Autowired
    public TestController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

}
