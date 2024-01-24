package com.example.springredistest.controller;

import com.example.springredistest.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket(){
        ticketService.getTicketByMemberNo(3);

        return "success";
    }
}
