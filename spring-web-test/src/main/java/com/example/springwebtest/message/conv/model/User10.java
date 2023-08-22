package com.example.springwebtest.message.conv.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Slf4j
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User10 implements Response {

	private String emailYn;
	private String marketingYn;
}
