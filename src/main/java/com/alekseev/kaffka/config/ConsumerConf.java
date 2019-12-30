package com.alekseev.kaffka.config;

import com.alekseev.kaffka.dto.Employer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConf {

    @Bean
    public ConsumerFactory<String, Employer>employerConsumerFactory(){
        Map<String,Object>configProps=new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG,"0");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps,new StringDeserializer(),new JsonDeserializer<>(Employer.class));

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Employer>kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Employer> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(employerConsumerFactory());
        return factory;
    }
    }

