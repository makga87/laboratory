package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User6 implements Response {

	private String emailYn;
	private String marketingYn;

	public User6() {
		log.debug("### User6 기본 생성자");
	}

	public String getEmailYn() {
		log.debug("### getEmailYn 호출");
		return emailYn;
	}

	public String getMarketingYn() {
		return marketingYn;
	}
}
