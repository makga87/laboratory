package com.example.docker.controller;

import com.example.docker.dto.Member;
import com.example.docker.dto.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/api/v1.0/member/{memberNo}")
    public ResponseEntity<Member> getMember(@PathVariable("memberNo") int memberNo) {

        return ResponseEntity.ok(Member.builder()
                .name("홍길동")
                .age(35)
                .dept("개발팀")
                .build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/api/v1.0/member")
    public ResponseEntity<Result> setMember(@RequestBody Member member) {

        return ResponseEntity.ok(Result.builder()
                        .code(0)
                        .description("success")
                .build());
    }
}
