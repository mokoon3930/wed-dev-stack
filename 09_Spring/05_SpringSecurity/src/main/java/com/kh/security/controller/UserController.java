package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.service.UserService;
import com.kh.security.vo.User;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String register(User vo) {
		userService.register(vo);
		return "redirect:/login";
		
	}
	
	@PostMapping("/login")
	public String login(String id) {
		userService.login(id);
		return "redirect:/mypage";
		
	}
	
	
	
	
}
