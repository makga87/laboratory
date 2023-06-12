package com.example.springtxtest.repo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.springtxtest.model.Ticket;

@Mapper
public interface TicketRepository {

	@Select("select * from ticket t where t.use_yn = 'N' limit 1 for update")
	Ticket getTicket();


	@Update("update ticket t set t.use_yn = 'Y' where t.id = #{id}")
	int setTicket(int id);
}
