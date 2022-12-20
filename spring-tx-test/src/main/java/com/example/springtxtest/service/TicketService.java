package com.example.springtxtest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.example.springtxtest.model.Ticket;
import com.example.springtxtest.repo.TicketHistoryRepository;
import com.example.springtxtest.repo.TicketRepository;

@RequiredArgsConstructor
@Service
public class TicketService {

	private final TicketHistoryRepository ticketHistoryRepository;
	private final TicketRepository ticketRepository;

	@Transactional
	public void serviceAsLoop() {
		for (int i = 0; i < 5; i++) {
			serviceTicket();
		}
	}

	public void serviceTicket() {
		Ticket ticket = ticketRepository.getTicket();
		ticketHistoryRepository.addTicketHistory(ticket.getId());
		ticketRepository.setTicket(ticket.getId());
	}
}
