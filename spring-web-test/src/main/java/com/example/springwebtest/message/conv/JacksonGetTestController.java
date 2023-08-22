
package com.example.springwebtest.message.conv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.example.springwebtest.message.conv.model.Response;
import com.example.springwebtest.message.conv.model.User1;
import com.example.springwebtest.message.conv.model.User2;
import com.example.springwebtest.message.conv.model.User3;
import com.example.springwebtest.message.conv.model.User4;
import com.example.springwebtest.message.conv.model.User5;
import com.example.springwebtest.message.conv.model.User6;
import com.example.springwebtest.message.conv.model.User7;
import com.example.springwebtest.message.conv.model.User8;

@Slf4j
@RequestMapping("/get")
@RestController
public class JacksonGetTestController {

	@GetMapping("/jackson/test1")
	public Response jacksonTest(@RequestBody User1 user) {
		log.debug("[AllArgs + NoArgus] user1 : {}", user);
		return user;
	}


	@GetMapping("/jackson/test2")
	public Response jacksonTest(@RequestBody User2 user) {
		log.debug("[NoArgus] user2 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test3")
	public Response jacksonTest(@RequestBody User3 user) {
		log.debug("[AllArgs] user3 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test4")
	public Response jacksonTest(@RequestBody User4 user) {
		log.debug("[AllArgs + NoArgus(private)] user4 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test5")
	public Response jacksonTest(@RequestBody User5 user) {
		log.debug("user5 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test6")
	public Response jacksonTest(@RequestBody User6 user) {
		log.debug("user6 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test7")
	public Response jacksonTest(@RequestBody User7 user) {
		log.debug("user7 : {}", user);
		return user;
	}

	@GetMapping("/jackson/test8")
	public Response jacksonTest(@RequestBody User8 user) {
		log.debug("user8 : {}", user);
		return user;
	}
}
