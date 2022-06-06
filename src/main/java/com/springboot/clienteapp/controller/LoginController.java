package com.springboot.clienteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String Index(Model model,
			@RequestParam(name="error",required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "views/login/login";
	}
	
	@GetMapping("/logedin")
	public String loginCheck() {
		return "redirect:/index/";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "views/login/login";
	}
}
