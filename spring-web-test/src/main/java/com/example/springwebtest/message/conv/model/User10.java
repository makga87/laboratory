package com.example.springwebtest.message.conv.model;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Slf4j
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User10 implements Response {

	private String emailYn;
	private String marketingYn;
}
