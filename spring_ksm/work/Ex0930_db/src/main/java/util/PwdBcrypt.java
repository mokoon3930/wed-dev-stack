package util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import vo.MemberVO;

public class PwdBcrypt {
	
	//암호화
	public String encodingPwd( String pwd ) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String encodedPwd = encoder.encode(pwd);
		
		//암호화된 비밀 번호를 반환
		return encodedPwd;
		
	}
	
	//복호화(비밀 번호 체크)
	public boolean validPwd( String inputPw ,String oriPw ) {
		
		boolean isValid = false;
		
		// 						입련한 비번, 암호화된 비번
		isValid = BCrypt.checkpw(inputPw, oriPw);
		
		return isValid;
	}
}
