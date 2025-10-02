package controller;

import org.springframework.stereotype.Controller;

import dao.MemberDAO;

@Controller
public class MemberController {

	MemberDAO member_dao;
	
	public MemberController(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
}
