package com.example.springinflearntoby.config.autoconfig;

import com.example.springinflearntoby.config.ConditionalMyOnClass;
import com.example.springinflearntoby.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
class TomcatWebserverConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 유저 구성 정보의 해당 인터페이스 구성정보가 없는 경우에만 실행
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}
