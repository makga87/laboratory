package com.example.springwebtest.message.conv;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.example.springwebtest.message.conv.model.*;

@Slf4j
@RestController
public class JacksonPostTestController {

	/**
	 * 기본생성자 public + 파라메터 생성자 public
	 * getter + setter
	 */
	@PostMapping("/jackson/test1")
	public Response jacksonTest(@RequestBody User1 user) {
		log.debug("[AllArgs + NoArgus] user1 : {}", user);
		return user;
	}

	/**
	 * 기본생성자 public
	 * getter + setter
	 */
	@PostMapping("/jackson/test2")
	public Response jacksonTest(@RequestBody User2 user) {
		log.debug("[NoArgus] user2 : {}", user);
		return user;
	}

	/**
	 * 파라메터 생성자 public
	 * getter + setter
	 */
	@PostMapping("/jackson/test3")
	public Response jacksonTest(@RequestBody User3 user) {
		log.debug("[AllArgs] user3 : {}", user);
		return user;
	}

	/**
	 * 기본생성자 public + 파라메터 생성자 public
	 * getter + setter
	 */
	@PostMapping("/jackson/test4")
	public Response jacksonTest(@RequestBody User4 user) {
		log.debug("[AllArgs + NoArgus(private)] user4 : {}", user);
		return user;
	}

	@PostMapping("/jackson/test5")
	public Response jacksonTest(@RequestBody User5 user) {
		log.debug("user5 : {}", user);
		return user;
	}

	@PostMapping("/jackson/test6")
	public Response jacksonTest(@RequestBody User6 user) {
		log.debug("user6 : {}", user);
		return user;
	}

	@PostMapping("/jackson/test7")
	public Response jacksonTest(@RequestBody User7 user) {
		log.debug("user7 : {}", user);
		return user;
	}

	@PostMapping("/jackson/test8")
	public Response jacksonTest(@RequestBody User8 user) {
		log.debug("user8 : {}", user);
		return user;
	}

	/**
	 * 파라메터 생성자
	 * getter + setter
	 */
	@PostMapping("/jackson/test9")
	public Response jacksonTest(@RequestBody User9 user) {
		log.debug("user9 : {}", user);
		return user;
	}

	/**
	 * getter setter 없이, @JsonAutoDetect가 있는 경우
	 */
	@PostMapping("/jackson/test10")
	public Response jacksonTest(@RequestBody User10 user) {
		log.debug("user10 : {}", user);
		return user;
	}

	/**
	 * 불필요한 필드가 있는 경우, 필드는 없지만 getter + setter가 있는 경우
	 */
	@PostMapping("/jackson/test11")
	public Response jacksonTest(@RequestBody User11 user) {
		log.debug("user11 : {}", user);
		return user;
	}

	/**
	 * request body와 queryString이 둘 다 존재하는 경우
	 */
	@PostMapping("/jackson/test12")
	public Response jacksonTest(@RequestBody User12 user, String salesYn) {
		user.setSalesYn(salesYn);
		log.debug("user12 : {}", user);
		return user;
	}
}
