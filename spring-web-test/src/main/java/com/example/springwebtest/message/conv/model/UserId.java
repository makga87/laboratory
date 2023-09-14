package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserId {
	private int userId;

	public UserId(){
		log.debug("## Default Constructor requested!");
	}

	public int getUserId() {
		return userId;
	}
}
