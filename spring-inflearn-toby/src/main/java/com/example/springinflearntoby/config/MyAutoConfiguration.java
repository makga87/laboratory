package com.example.springinflearntoby.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration(proxyBeanMethods = false) // 스프링에서 자동으로 생성해주는 프록시 클래스를 사용 여부 결정 (default = true)
public @interface MyAutoConfiguration {

}
