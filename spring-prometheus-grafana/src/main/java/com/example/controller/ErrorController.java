package com.example.controller;

import com.example.dto.Member;
import com.example.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class ErrorController {

    @GetMapping("/error")
    public ResponseEntity<Void> getError() {

        log.error("Error occur controller", new RuntimeException());

        return ResponseEntity
                .internalServerError()
                .build();
    }

    @GetMapping("/latency")
    public ResponseEntity<Void> getLatency() throws InterruptedException {

        Thread.sleep(30000);

        return ResponseEntity.ok().build();
    }
}
