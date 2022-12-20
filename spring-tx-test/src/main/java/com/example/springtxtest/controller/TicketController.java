package com.example.springtxtest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.example.springtxtest.service.TicketService;

@RequiredArgsConstructor
@RestController
public class TicketController {
	private final TicketService ticketService;

	@PostMapping("/ticket")
	public void postTicket() {
		ticketService.serviceAsLoop();
	}

}
