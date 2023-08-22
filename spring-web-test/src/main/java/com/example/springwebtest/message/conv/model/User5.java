package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User5 implements Response {

	private String emailYn;
	private String marketingYn;

	public User5(String emailYn, String marketingYn) {
		log.debug("### User5 파라메터 생성자");
		this.emailYn = emailYn;
		this.marketingYn = marketingYn;
	}

	public String getEmailYn() {
		log.debug("### getEmailYn 호출");
		return getMarketingYn();
	}

	public String getMarketingYn() {
		return marketingYn;
	}
}
