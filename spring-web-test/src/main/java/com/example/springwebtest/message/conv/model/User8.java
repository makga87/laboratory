package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User8 implements Response {

	private String emailYn;
	private String marketingYn;

	public User8() {
		log.debug("### User8 기본 생성자");
	}

	public void setEmailYn(String emailYn) {
		log.debug("### setEmailYn 호출");

		setMarketingYn(emailYn);
	}
	public void setMarketingYn(String marketingYn) {
		this.marketingYn = marketingYn;
	}

}
