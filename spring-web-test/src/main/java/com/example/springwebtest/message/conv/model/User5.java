package com.example.springwebtest.message.conv.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User5 implements Response {

	private String emailYn;
	private String marcketingYn;

	public User5(String emailYn, String marcketingYn) {
		log.debug("### User5 파라메터 생성자");
		this.emailYn = emailYn;
		this.marcketingYn = marcketingYn;
	}

	public String getEmailYn() {
		log.debug("### getEmailYn 호출");
		return getMarcketingYn();
	}

	public String getMarcketingYn() {
		return marcketingYn;
	}
}
