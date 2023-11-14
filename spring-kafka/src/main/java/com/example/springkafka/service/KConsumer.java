package com.example.springkafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KConsumer {

	@KafkaListener(topics = "payment", groupId = "payment-group")
	public void consume(String msg) {

		log.info("[Consumer] msg = {}", msg);

	}
}
