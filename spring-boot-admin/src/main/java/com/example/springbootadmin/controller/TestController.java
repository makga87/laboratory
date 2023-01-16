package com.example.springbootadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@GetMapping("/test")
	public void test1() {

	}

	@PostMapping("/test")
	public ResponseEntity test2(@RequestBody Request request) {
		log.debug("debug {}", request);
		log.info("info {}", request);
		log.error("error {}", request);
		log.warn("warn {}", request);
		return ResponseEntity.ok().build();
	}


}
