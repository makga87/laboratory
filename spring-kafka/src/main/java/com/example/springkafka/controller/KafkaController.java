package com.example.springkafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.example.springkafka.service.KProducer;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {

	private final KProducer producer;

	@GetMapping("/produce")
	public String sendMessage(@RequestParam("msg") String msg) {
		producer.sendMsg(msg);
		return "succes";
	}
}
