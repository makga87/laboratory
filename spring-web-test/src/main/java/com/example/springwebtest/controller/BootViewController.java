package com.example.springwebtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BootViewController {

	@GetMapping("/")
	public String index(){
		return "index";
	}
}
