package com.example.springdbpooltest.controller;

import com.example.springdbpooltest.model.User;
import com.example.springdbpooltest.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/conn/test")
    public ResponseEntity<Object> connTest() {
        try {
            List<User> userList = testRepository.getUsers();
            log.debug("result = {}", userList);
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
