package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User2 implements Response {

    private String emailYn;
    private String marcketingYn;


    public User2() {
        log.debug("### User2 기본 생성자");
    }

    public String getEmailYn() {
        log.debug("### getEmailYn 호출");

        return getMarcketingYn();
    }

    public void setEmailYn(String emailYn) {
        log.debug("### setEmailYn 호출");

        setMarcketingYn(emailYn);
    }

    public String getMarcketingYn() {
        return marcketingYn;
    }

    public void setMarcketingYn(String marcketingYn) {
        this.marcketingYn = marcketingYn;
    }
}
