package com.example.springwebtest.message.conv.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User9 implements Response {

    private String emailYn;
    private String marketingYn;

    public User9(String emailYn, String marketingYn) {
        log.debug("### User9 파라메터 생성자 emailYn={}, marketingYn={}", emailYn, marketingYn);
        this.emailYn = emailYn;
        this.marketingYn = marketingYn;
    }


	public String getEmailYn() {
		log.debug("### getEmailYn 호출");

		return emailYn;
	}

	public String getMarketingYn() {
		log.debug("### getMarketingYn 호출");

		return marketingYn;
	}

	public void setEmailYn(String emailYn) {
		log.debug("### setEmailYn 호출");

		this.emailYn = emailYn;
	}

	public void setMarketingYn(String marketingYn) {
		log.debug("### setMarketingYn 호출");

		this.marketingYn = marketingYn;
	}
}
