package com.example.springwebtest.message.conv.model;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class User3 implements Response {

    private String emailYn;
    private String marketingYn;

    public User3(String emailYn, String marketingYn) {
        log.debug("### User3 파라메터 생성자 emailYn={}, marketingYn={}", emailYn, marketingYn);
        this.emailYn = emailYn;
        this.marketingYn = marketingYn;
    }

    public String getEmailYn() {
        log.debug("### getEmailYn 호출");

        return getMarketingYn();
    }

    public void setEmailYn(String emailYn) {
        log.debug("### setEmailYn 호출");

        setMarketingYn(emailYn);
    }

    public String getMarketingYn() {
        return marketingYn;
    }

    public void setMarketingYn(String marketingYn) {
        this.marketingYn = marketingYn;
    }
}
