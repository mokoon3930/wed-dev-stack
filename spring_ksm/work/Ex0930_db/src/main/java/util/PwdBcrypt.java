package util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import vo.MemberVO;

public class PwdBcrypt {
	
	//��ȣȭ
	public String encodingPwd( String pwd ) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String encodedPwd = encoder.encode(pwd);
		
		//��ȣȭ�� ��� ��ȣ�� ��ȯ
		return encodedPwd;
		
	}
	
	//��ȣȭ(��� ��ȣ üũ)
	public boolean validPwd( String inputPw ,String oriPw ) {
		
		boolean isValid = false;
		
		// 						�Է��� ���, ��ȣȭ�� ���
		isValid = BCrypt.checkpw(inputPw, oriPw);
		
		return isValid;
	}
}
