package com.example.springmodulecomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class SpringModuleComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringModuleComponentApplication.class, args);
	}

}
