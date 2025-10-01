package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class LoginController {
	
	MemberDAO member_dao;
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	
	
	@RequestMapping("/login.do")
	public String loginForm() {
		return "login/login_form";
	}
	
	//check_login.do?id=a&pwq=1111
	@RequestMapping("check_login.do")
	@ResponseBody
	public String login( MemberVO vo) {
		
		MemberVO baseVO = member_dao.selectIdCheck(vo.getId());
		
		String result = "";
		
		//DB에 아이디가 없음
		if(baseVO == null) {
			result = "no_id";
			String resultStr = String .format("[{'res':'%s'}]", result);
			return resultStr;
		}
		//비밀 번호 없을때
		PwdBcrypt pbc = new PwdBcrypt();
		boolean isValid = pbc.validPwd(vo.getPwd(), baseVO.getPwd());
		if( !isValid ) {
			result = "no_pwd";
			String resultStr = String .format("[{'res':'%s'}]", result);
			return resultStr;
		}
		
		//둘다 성공
		result = "clear";
		String resultStr = String .format("[{'res':'%s'}]", result);
		return resultStr;
		
	}
	
}

















