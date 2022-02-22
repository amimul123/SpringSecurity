package com.ami.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	private String home(Model model) {
		model.addAttribute("navActive", "home");
		return"home.html";

	}
	
	@GetMapping("/login")
	private String login() {
		return"login.html";

	}
	
	@GetMapping("/user")
	private String user(Model model) {
		model.addAttribute("navActive", "user");
		return"user.html";

	}
	
	@GetMapping("/admin")
	private String admin(Model model) {
		model.addAttribute("navActive", "admin");
		return"admin.html";

	}

}
