package com.example.docker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ErrorController {

    @GetMapping("/error")
    public void getError() {
        log.error("Error controller", (new RuntimeException("error controller")).getCause().getMessage());
    }
}
