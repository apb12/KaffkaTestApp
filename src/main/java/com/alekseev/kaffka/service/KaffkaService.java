package com.alekseev.kaffka.service;

import com.alekseev.kaffka.dto.Empoyer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KaffkaService {
    @KafkaListener(topics = "users",containerFactory = "empoyerConcurrentKafkaListenerContainerFactory")
    public void emplOut(Empoyer empoyer){
        System.out.println(empoyer);
    }
}
