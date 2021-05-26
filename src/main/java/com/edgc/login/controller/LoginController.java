package com.edgc.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgc.login.service.LoginApiService;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	LoginApiService loginService;
	
	@GetMapping(value = {"/", ""})
	public String index() {
		return "login/index";
	}
}
