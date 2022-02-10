package com.example.controller;

import com.example.dto.Member;
import com.example.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class MemberController {

    @GetMapping("/api/v1.0/member/{memberNo}")
    public ResponseEntity<Member> getMember(@PathVariable("memberNo") int memberNo) {

        log.info("{}", memberNo);

        return ResponseEntity.ok(Member.builder()
                .name("홍길동")
                .age(35)
                .dept("개발팀")
                .build());
    }

    @PostMapping("/api/v1.0/member")
    public ResponseEntity<Result> setMember(@RequestBody Member member) {

        log.info("{}", member);

        return ResponseEntity.ok(Result.builder()
                .code(0)
                .description("success")
                .build());
    }
}
