package com.example.springinflearntoby;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

    @Test
    void helloApi() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> res = testRestTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        Assertions.assertThat(res.getBody()).isEqualTo("*HelloSpring*");
    }
}
