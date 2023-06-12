package com.example.springtxtest.controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.example.springtxtest.service.TicketService;

@RequiredArgsConstructor
@RestController
public class TicketController {
	private final TicketService ticketService;

	@PostMapping("/ticket")
	public void postTicket() throws InterruptedException {

		int count = 2;
		CountDownLatch countDownLatch = new CountDownLatch(count);

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (int i = 0; i < count; i++) {
			executorService.execute(() -> {
				try {
					ticketService.serviceAsLoop();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			});
		}

		countDownLatch.await();

	}

}
