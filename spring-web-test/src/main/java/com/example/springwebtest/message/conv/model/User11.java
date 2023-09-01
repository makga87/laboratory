package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User11 implements Response {

	private String emailYn;
	private String testField;

	public String getEmailYn() {
		log.debug("### getEmailYn 호출");

		return getMarketingYn();
	}

	public void setEmailYn(String emailYn) {
		log.debug("### setEmailYn 호출");
		setMarketingYn(emailYn);
	}

	public String getMarketingYn() {
		return this.emailYn;
	}

	public void setMarketingYn(String marketingYn) {
		this.emailYn = marketingYn;
	}
}
