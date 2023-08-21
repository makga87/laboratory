package com.example.springwebtest.message.conv.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Data
public class User3 implements Response {

    private String emailYn;
    private String marcketingYn;

    public User3(String emailYn, String marcketingYn) {
        log.debug("### User3 파라메터 생성자");
        this.emailYn = emailYn;
        this.marcketingYn = marcketingYn;
    }

    public User3() {
        log.debug("### User3 기본 생성자");
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
