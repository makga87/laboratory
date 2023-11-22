package com.example.springmultimodule.feat.reserve;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reserve")
public class ReserveController {

	private final ReserveService reserveService;

	@GetMapping("/no")
	public ResponseEntity getReserveNoByMemberNo(@RequestParam("memberNo") int memberNo) {
		return ResponseEntity.ok(reserveService.getReserveNoByMemberNo(memberNo));
	}

	@GetMapping("/no/{reserveNo}")
	public ResponseEntity getReserveInfo(@PathVariable("reserveNo") int reserveNo) {
		return ResponseEntity.ok(reserveService.getReserveInfoByReserveNo(reserveNo));
	}
}
