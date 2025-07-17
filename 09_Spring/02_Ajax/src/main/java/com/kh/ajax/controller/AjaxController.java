package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;

@Controller
public class AjaxController {
	
	@Autowired
	private MemberService service;
	private int count = 0;
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax 요청!");
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname) {
		return nickname;
		
	}
	
	
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		//Member member = service.idCheck(id);
		//if(member!=null) return true;
		return service.idBoolCheck(id);
	}
	

	@ResponseBody
	@PostMapping("/signup")
	public void check(Member vo) {
		System.out.println(vo.getId());
		System.out.println(vo.getPwd());
		System.out.println(vo.getName());
	}
	
	

	
	
}
