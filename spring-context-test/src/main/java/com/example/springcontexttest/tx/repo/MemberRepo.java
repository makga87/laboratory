package com.example.springcontexttest.tx.repo;

import com.example.springcontexttest.tx.dto.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberRepo {

    @Insert("insert into member (id, name) values (#{id}, #{name})")
    int insert(Member member);

    @Delete("delete from member")
    int delete();

    @Update("update member set name = #{name}")
    int update(Member member);
}
