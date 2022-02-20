package com.ami.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/")
	private String home() {
		return"home.html";

	}
	
	@GetMapping("/login")
	private String login() {
		return"login.html";

	}
	
	@GetMapping("/user")
	private String user() {
		return"user.html";

	}
	
	@GetMapping("/admin")
	private String admin() {
		return"admin.html";

	}

}
