package com.example.springmultimodule.feat.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/no")
	public ResponseEntity getMemberNo() {
		return ResponseEntity.ok(memberService.getMemberNo());
	}
}
