package com.example.springkafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class KProducer {

	public static final String TOPIC = "payment";
	public final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMsg(String msg) {
		log.info("[Producer] msg = {}", msg);
		kafkaTemplate.send(TOPIC, msg);
	}


}
