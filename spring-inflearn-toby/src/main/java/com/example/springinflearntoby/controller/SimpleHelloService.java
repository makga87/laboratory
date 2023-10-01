package com.example.springinflearntoby.controller;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String contents) {
        return "Hello " + contents;
    }
}
