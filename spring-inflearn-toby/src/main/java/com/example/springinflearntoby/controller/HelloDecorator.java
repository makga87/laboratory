package com.example.springinflearntoby.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // 다수의 동일한 속성의 빈이 존재할 경우, 우선적으로 적용, Proxy 패턴과 유사
// Proxy란 실체가 존재하고, 실체 대신 동작을 할 객체, 실체 객체가 너무 비용이 비쌀 때, lazy로딩 혹은 remote api 호출 용
public class HelloDecorator implements HelloService {

    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }
}
