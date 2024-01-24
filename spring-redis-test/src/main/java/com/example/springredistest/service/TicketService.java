package com.example.springredistest.service;

import com.example.springredistest.model.Ticket;
import com.example.springredistest.repository.TicketMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketMapper ticketMapper;

    @Cacheable(value="Tickets", key = "#memberNo", cacheManager = "contentCacheManager")
    public List<Ticket> getTicketByMemberNo(int memberNo) {

      return ticketMapper.findByMemberNo(memberNo);

    }

    @PostConstruct
    public void init(){
       getTicketByMemberNo(3);
    }

}
