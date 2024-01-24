package com.example.springredistest.repository;

import com.example.springredistest.model.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TicketMapper {

    @Select("select * from ticket t where t.member_no = #{memberNo}")
    List<Ticket> findByMemberNo(int memberNo);
}
