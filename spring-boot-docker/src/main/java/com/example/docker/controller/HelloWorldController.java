package com.example.docker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World~");
    }
}
