package com.example.springwebtest.message.conv;

import com.example.springwebtest.message.conv.model.Response;
import com.example.springwebtest.message.conv.model.User1;
import com.example.springwebtest.message.conv.model.User2;
import com.example.springwebtest.message.conv.model.User3;
import com.example.springwebtest.message.conv.model.User4;
import com.example.springwebtest.message.conv.model.User5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JacksonTestController {

    @PostMapping("/jackson/test1")
    public Response jacksonTest(@RequestBody User1 user) {
        log.debug("[AllArgs + NoArgus] user1 : {}", user);
        return user;
    }


    @PostMapping("/jackson/test2")
    public Response jacksonTest(@RequestBody User2 user) {
        log.debug("[NoArgus] user2 : {}", user);
        return user;
    }

    @PostMapping("/jackson/test3")
    public Response jacksonTest(@RequestBody User3 user) {
        log.debug("[AllArgs] user3 : {}", user);
        return user;
    }

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
}
