package com.example.docker.controller;

import com.example.docker.dto.Member;
import com.example.docker.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MainController {

    @GetMapping("/main")
    public void getMember() {
    }
}
