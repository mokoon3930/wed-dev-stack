package service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSendService {

	private JavaMailSender javaMailSender;
	private int authNumber = 0;
	
	// 생성자 주입
	public MailSendService( JavaMailSender javaMailSender ) {
		this.javaMailSender = javaMailSender;
	}
	
	//난수로 인증번호 생성
	public void makeRandomNumber() {
		Random rnd = new Random();
		//난수범위 111111 ~ 999999 중 랜덤값(rnd)
		int checkNum = rnd.nextInt( 999999 - 111111 + 1 ) + 111111;
		System.out.println( "인증번호 : " + checkNum );
		
		// 램덤으로 생성된 값을 담음
		authNumber = checkNum;
	}
	
	//이메일을 전달하는 방식
	public String joinEmail( String email ) {
		
		makeRandomNumber();						 // 인증 번호를 생성을 하는 구문
		String setForm = "rkdtjdah17@naver.com"; // 보네는 이메일 주소 
		String toMail = email;					 // 받는 이메일 주소 jsp 에서 input으로 email 받음
		String title = "이메일 인증메일";			 // 제목	
		
		String content = "인증번호는 <b>" + authNumber + "</b>입니다"; // 내용 authNumber = checkNum 위쪽 난수 생성
		
		// 위의 값의 형테로 이메일을 rkdtjdah17@naver.com 에서 email(입력 받은 이메일) 로 전송을 한다.
		
		try {
			
			MimeMessage mail = javaMailSender.createMimeMessage(); // mail 객체를 생성
			MimeMessageHelper mailHelper = 
					new MimeMessageHelper( mail, true, "UTF-8" ); // true 가 있어야 첨부된 내용을 보네는것을 허용한다.
			
			mailHelper.setFrom( setForm );
			mailHelper.setTo( toMail );
			mailHelper.setSubject( title );
			mailHelper.setText(content, true); // true 가 있어야 content 에 담긴 내용이 그대로 보인다
			
			javaMailSender.send(mail); // 스프링에서 제공하는 메일 전송 객체 (서버에서 설정을 한 정보로 보넨다)
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return String.valueOf( authNumber ); // 다시 전송을 한 사람 에게도 보네주는 구문 		
	}//joinEmail()
	
}















