package com.example.springkafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class KafkaConfiguration {

	private final KafkaTemplate<String, String> kafkaTemplate;

}
