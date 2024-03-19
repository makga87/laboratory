package com.example.springredistest.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.springredistest.model.Ticket;

@SpringBootTest
class RedisConfigurationTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;


	@DisplayName("Redis 문자열 타입 데이터 테스트")
	@Test
	void testRedisStringDataType() {
		String key = "ticket1";
		Ticket value = new Ticket(1, 1);
		redisTemplate.opsForValue().set(key, value.toString());
		String ticket = (String) redisTemplate.opsForValue().get(key);

		System.out.println(ticket);

		Assertions.assertEquals(value.toString(), ticket);
	}


}