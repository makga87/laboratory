package com.example.springkafka.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class KafkaControllerTest {

	@Test
	void kafkaTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/kafka/produce", String.class, "Hello Kafka~");
		String result = response.getBody();
		System.out.println(result);
	}

}