package com.alekseev.kaffka.service;

import com.alekseev.kaffka.dto.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KaffkaService {
    @Autowired
    private SaveJooqKaffka saveJooqKaffka;
    @KafkaListener(topics = "users",groupId = "0",containerFactory = "kafkaListenerContainerFactory")
    public void emplOut(Employer empoyer){
        saveJooqKaffka.saveEmpl(empoyer);
        System.out.println(empoyer);
    }
}
