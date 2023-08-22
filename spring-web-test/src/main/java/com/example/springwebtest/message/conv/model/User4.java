package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User4 implements Response {

    private String emailYn;
    private String marketingYn;

    public User4(String emailYn, String marketingYn) {
        log.debug("### User4 파라메터 생성자");
        this.emailYn = emailYn;
        this.marketingYn = marketingYn;
    }

    private User4() {
        log.debug("### User4 기본 생성자");
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
