package com.example.springmodulecomponent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.example.springmodulecomponent.service.UserService;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
	private final UserService userService;

	@GetMapping("/no")
	public ResponseEntity getUserNo() {
		return ResponseEntity.ok(userService.getMemberNo());
	}
}
