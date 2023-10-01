package com.example.springinflearntoby;

import com.example.springinflearntoby.config.MySpringBootAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootAnnotation
public class SpringInflearnTobyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringInflearnTobyApplication.class, args);
    }


}
