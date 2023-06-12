package com.example.springtxtest.repo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketHistoryRepository {

	@Insert("insert into ticket_history (ticket_id) values(#{ticketId})")
	int addTicketHistory(int ticketId);
}
