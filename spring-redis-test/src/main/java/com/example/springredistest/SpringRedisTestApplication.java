package com.example.springredistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringRedisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisTestApplication.class, args);
    }

}
