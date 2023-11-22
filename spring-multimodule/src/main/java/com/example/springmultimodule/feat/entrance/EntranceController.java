package com.example.springmultimodule.feat.entrance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/entrance")
public class EntranceController {

	private final EntranceService entranceService;

	@GetMapping("/no")
	public ResponseEntity getEntranceNoByReserveNo(@RequestParam("reserveNo") int reserveNo) {
		return ResponseEntity.ok(entranceService.getEntranceInfoByReserveNo(reserveNo));
	}
}
