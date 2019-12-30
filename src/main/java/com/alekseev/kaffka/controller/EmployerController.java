package com.alekseev.kaffka.controller;

import com.alekseev.kaffka.dto.Empoyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class EmployerController {
    private static final String TOPIC="users";
    @Autowired
    private KafkaTemplate<String, Empoyer>kafkaTemplate;

    @GetMapping("/{name}")
    public String getEmpl(@PathVariable("name")String name){
        kafkaTemplate.send(TOPIC,new Empoyer(name,40));
        return "send sucsecfully";

    }
}
