package com.kh.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MailSendService;

@Controller
public class EmailController {

	MailSendService mss;
	
	// 생성자 주입
	public EmailController (MailSendService mss) {
		this.mss = mss;
	}
	
	// email 확인 페이지 
	@RequestMapping(value = {"/", "start.do"})
	public String start() {
		return "email_sender";
	}
	
	// email 인증번호 확인하는 부분 jsp 에서 param으로 email 받음
	@RequestMapping("/mailCheck.do")
	// Ajax로 처리하는 구문이라 @ResponsBody 필요
	@ResponseBody
	public String mailCheck(String email) {
		
		String res = mss.joinEmail(email);
		return res;
	}
	
}

