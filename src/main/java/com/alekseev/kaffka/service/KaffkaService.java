package com.alekseev.kaffka.service;

import com.alekseev.kaffka.dto.Employer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KaffkaService {
    @KafkaListener(topics = "users",groupId = "0",containerFactory = "kafkaListenerContainerFactory")
    public void emplOut(Employer empoyer){
        System.out.println(empoyer);
    }
}
