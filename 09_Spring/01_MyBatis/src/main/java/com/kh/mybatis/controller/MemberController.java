package com.kh.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/")
	public String index(Model model) {
		// List<Member> list = service.allMember(); 변수 지정 1번 / 아래 바로 담아 내기 2번
		 model.addAttribute("list", service.allMember());
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}

	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	} // index.jsp 호출

	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}

	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		Member member = service.login(vo);
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		return "redirect:/";
	}

	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		vo.setId(member.getId());
		service.update(vo);
		session.setAttribute("member", vo);
		return "redirect:/";
	}

}
