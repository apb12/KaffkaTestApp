package com.alekseev.kaffka.config;

import com.alekseev.kaffka.dto.Empoyer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConf {

    @Bean
    private ConsumerFactory<String, Empoyer>empoyerConsumerFactory(){
        Map<String,Object>configProps=new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps,new StringDeserializer(),new JsonDeserializer<>(Empoyer.class));

    }
    @Bean
    private ConcurrentKafkaListenerContainerFactory<String,Empoyer>empoyerConcurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Empoyer> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(empoyerConsumerFactory());
        return factory;
    }
    }

