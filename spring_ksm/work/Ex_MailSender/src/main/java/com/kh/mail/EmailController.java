package com.kh.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MailSendService;

@Controller
public class EmailController {

	MailSendService mss;
	
	// ������ ����
	public EmailController (MailSendService mss) {
		this.mss = mss;
	}
	
	// email Ȯ�� ������ 
	@RequestMapping(value = {"/", "start.do"})
	public String start() {
		return "email_sender";
	}
	
	// email ������ȣ Ȯ���ϴ� �κ� jsp ���� param���� email ����
	@RequestMapping("/mailCheck.do")
	// Ajax�� ó���ϴ� �����̶� @ResponsBody �ʿ�
	@ResponseBody
	public String mailCheck(String email) {
		
		String res = mss.joinEmail(email);
		return res;
	}
	
}

