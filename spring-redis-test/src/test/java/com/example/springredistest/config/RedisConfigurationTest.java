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

	/**
	 * 캐싱할 객체에 반드시 implements Serializable 필요
	 */
	@DisplayName("Redis Hash 타입 데이터 테스트")
	@Test
	void testRedisHashDataType() {
		String key = "ticket1";
		String hashKey = "hashKey1";
		Ticket value = new Ticket(1, 1);

		redisTemplate.opsForHash().put(key, hashKey, value);
		Ticket ticket = (Ticket) redisTemplate.opsForHash().get(key, hashKey);

		System.out.println(ticket);

		Assertions.assertNotNull(ticket);
		Assertions.assertEquals(value.toString(), ticket.toString());
	}


	@DisplayName("Redis List 타입 데이터 테스트")
	@Test
	void testRedisListDataType() {


		String key = "tickets";
		redisTemplate.opsForList().getOperations().delete(key);

		redisTemplate.opsForList().rightPush(key, new Ticket(1, 1));
		redisTemplate.opsForList().leftPush(key, new Ticket(2, 2));
		redisTemplate.opsForList().rightPush(key, new Ticket(3, 3));
		System.out.println(redisTemplate.opsForList().getOperations().opsForList().range(key, 0, -1));
		System.out.println("==================================================");

		redisTemplate.opsForList().rightPop(key);
		redisTemplate.opsForList().rightPop(key);

		System.out.println(redisTemplate.opsForList().getOperations().opsForList().range(key, 0, -1));
		System.out.println("==================================================");
		redisTemplate.opsForList().getOperations().delete(key);

	}


	@DisplayName("Redis Set 타입 데이터 테스트")
	@Test
	void testRedisSetDataType() {

		String key = "tickets";
		redisTemplate.opsForSet().getOperations().delete(key);

		redisTemplate.opsForSet().add(key, new Ticket(1, 1));
		redisTemplate.opsForSet().add(key, new Ticket(2, 2));
		redisTemplate.opsForSet().add(key, new Ticket(3, 3));
		redisTemplate.opsForSet().add(key, new Ticket(4, 4));
		redisTemplate.opsForSet().add(key, new Ticket(5, 5));
		System.out.println(redisTemplate.opsForSet().members(key));
		System.out.println("==================================================");

		redisTemplate.opsForSet().pop(key);

		System.out.println(redisTemplate.opsForSet().members(key));
		System.out.println("==================================================");

	}

	@DisplayName("Redis Sorted Set 타입 데이터 테스트")
	@Test
	void testRedisSortedSetDataType() {

		String key = "tickets";
		redisTemplate.opsForZSet().getOperations().delete(key);

		redisTemplate.opsForZSet().add(key, new Ticket(1, 1), 5);
		redisTemplate.opsForZSet().add(key, new Ticket(2, 2), 4);
		redisTemplate.opsForZSet().add(key, new Ticket(3, 3), 3);
		redisTemplate.opsForZSet().add(key, new Ticket(4, 4), 2);
		redisTemplate.opsForZSet().add(key, new Ticket(5, 5), 1);
		System.out.println(redisTemplate.opsForZSet().range(key, 0, -1));
		System.out.println("==================================================");

		redisTemplate.opsForZSet().incrementScore(key, new Ticket(2, 2), 2);
		redisTemplate.opsForZSet().popMax(key);

		System.out.println(redisTemplate.opsForZSet().range(key, 0, -1));
		System.out.println("==================================================");
	}


	@DisplayName("Redis Set 타입 isMember 테스트")
	@Test
	void testRedisSetSscan() {

		String key = "tickets";
		redisTemplate.opsForSet().getOperations().delete(key);

		redisTemplate.opsForSet().add(key, "banana");
		redisTemplate.opsForSet().add(key, "apple");
		redisTemplate.opsForSet().add(key, "kiwi");

		Boolean result = redisTemplate.opsForSet().isMember(key, "apple");
		System.out.println(result);
		System.out.println("==================================================");

		Assertions.assertTrue(result);
	}

}