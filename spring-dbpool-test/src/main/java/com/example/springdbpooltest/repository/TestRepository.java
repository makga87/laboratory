package com.example.springdbpooltest.repository;

import com.example.springdbpooltest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestRepository {

    @Select("select * from user")
    public List<User> getUsers();
}
