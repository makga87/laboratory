package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User7 implements Response {

	private String emailYn;
	private String marcketingYn;

	public User7() {
		log.debug("### User7 기본 생성자");
	}

}
