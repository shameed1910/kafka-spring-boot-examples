/*
package com.technotown.kafka.springbootkafka.controller;

import com.technotown.kafka.springbootkafka.model.Location;
import com.technotown.kafka.springbootkafka.model.Order;
import com.technotown.kafka.springbootkafka.service.ProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class ProducerController {

    private final ProducerService producerService;


    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public String sendLocationMessage(@RequestBody Location location) {
        producerService.sendLocationMessage(location);
        System.out.println("Successfully Published the Location = '" + location + "' to the test topic");
        return "Successfully Published the Location = '" + location + "' to the test topic";
    }


}
*/
