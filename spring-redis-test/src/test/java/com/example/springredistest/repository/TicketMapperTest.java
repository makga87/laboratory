package com.example.springredistest.repository;

import com.example.springredistest.model.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;


@Slf4j
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TicketMapperTest {

    @Autowired
    private TicketMapper ticketMapper;

    @Test
    void test() {
        List<Ticket> tickets = ticketMapper.findByMemberNo(3);
        log.info("###### {}", tickets);
    }
}