package com.example.springwebtest.message.conv.model;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
public class User12 implements Response {

	private String emailYn;
	private String marketingYn;
	private String salesYn;

	public User12() {
		log.debug("### User12 기본 생성자");
	}

	public String getEmailYn() {
		log.debug("### getEmailYn 호출");
		return this.emailYn;
	}

	public void setEmailYn(String emailYn) {
		log.debug("### setEmailYn 호출");
		this.emailYn = emailYn;
	}

	public String getMarketingYn() {
		log.debug("### getMarketingYn 호출");
		return this.marketingYn;
	}

	public void setMarketingYn(String marketingYn) {
		log.debug("### setMarketingYn 호출");
		this.marketingYn = marketingYn;
	}

	public String getSalesYn() {
		return salesYn;
	}

	public void setSalesYn(String salesYn) {
		this.salesYn = salesYn;
	}
}
