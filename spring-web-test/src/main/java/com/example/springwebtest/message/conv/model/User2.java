package com.example.springwebtest.message.conv.model;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
@ToString
@Slf4j
public class User2 implements Response {

    private String emailYn;
    private String marketingYn;

    public User2() {
        log.debug("### User2 기본 생성자");
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
