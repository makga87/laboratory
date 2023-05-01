package com.example.springinflearntoby.controller;

public class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String contents) {
        return "Hello" + contents;
    }
}
