package com.example.docker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public ResponseEntity<Map> helloWorld(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("data", "Hello World");
        return ResponseEntity.ok(dataMap);
    }
}
