package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.security.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
}
