package com.edgc.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgc.login.model.LoginForm;
import com.edgc.login.service.LoginService;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@GetMapping(value = {"/", ""})
	public String index() {
		return "login/index";
	}
	
	@PostMapping(value = "/login")
	public String login(LoginForm loginForm) {
		return loginService.login(loginForm);
	}
}
