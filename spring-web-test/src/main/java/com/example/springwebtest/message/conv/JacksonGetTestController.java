
package com.example.springwebtest.message.conv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.example.springwebtest.message.conv.model.*;

@Slf4j
@RequestMapping("/get")
@RestController
public class JacksonGetTestController {

	@GetMapping("/jackson/test1")
	public Response jacksonTest(User1 user) {
		log.debug("[AllArgs + NoArgus] user1 : {}", user);
		return user;
	}


	@GetMapping("/jackson/test2")
	public Response jacksonTest(User2 user) {
		log.debug("[NoArgus] user2 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test3")
	public Response jacksonTest(User3 user) {
		log.debug("[AllArgs] user3 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test4")
	public Response jacksonTest(User4 user) {
		log.debug("[AllArgs + NoArgus(private)] user4 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test5")
	public Response jacksonTest(User5 user) {
		log.debug("user5 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test6")
	public Response jacksonTest(User6 user) {
		log.debug("user6 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test7")
	public Response jacksonTest(User7 user) {
		log.debug("user7 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test8")
	public Response jacksonTest(User8 user) {
		log.debug("user8 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test9")
	public Response jacksonTest(User9 user) {
		log.debug("user9 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test10")
	public Response jacksonTest(User10 user) {
		log.debug("user10 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test11")
	public Response jacksonTest(User11 user) {
		log.debug("user11 : {}", user);
		return user;
	}
}
