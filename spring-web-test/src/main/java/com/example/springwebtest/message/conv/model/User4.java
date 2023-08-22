package com.example.springwebtest.message.conv.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User4 implements Response {

    private String emailYn;
    private String marcketingYn;

    public User4(String emailYn, String marcketingYn) {
        log.debug("### User4 파라메터 생성자");
        this.emailYn = emailYn;
        this.marcketingYn = marcketingYn;
    }

    private User4() {
        log.debug("### User4 기본 생성자");
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
