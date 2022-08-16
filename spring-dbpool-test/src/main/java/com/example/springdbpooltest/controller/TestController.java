package com.example.springdbpooltest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/conn/test")
    public void connTest(){

    }
}
