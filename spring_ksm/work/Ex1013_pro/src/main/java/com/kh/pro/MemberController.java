package com.kh.pro;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import vo.MemberVO;
@Controller
public class MemberController {

	MemberDAO member_dao;
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	@RequestMapping("login_page.do")
	public String loginPage() {
		return "member/login";
	}
	
	@RequestMapping("login.do")
	@ResponseBody
	public String login(MemberVO vo) {
		
		String param = "";
		String resultStr = "";
		
		//id가 일치하지 않을 경우
		if(vo == null) {
			param = "no_id";
			resultStr = String.format("[{'param':'%s'}]", param);
			
			return resultStr;
		}
		
		//비밀번호 불일치
		if(vo == null) {
			param = "no_pwd";
			resultStr = String.format("[{'param':'%s'}]", param);
			return resultStr;
		}
		
		if(vo.getId().equals(resultStr) && vo.getPwd().equals(resultStr)) {
			param = "clear";
			resultStr = String.format("[{'param':'%s'}]", param);
			return resultStr;
		}
		return "list.do";
		
		
		
	}
}
