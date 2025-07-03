package controller.copy;

import java.sql.SQLException;

import dao.copy.MemberDAO2;
import vo.copy.Member2;

public class MemberController2 {

	private MemberDAO2 dao = MemberDAO2.getInstance();
	
	// 4. 회원가입
	public void register(Member2 member) {
		try {
			dao.register(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. 로그인
	public Member2 login(String id, String pwd) {
		return null;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴시 대여중인 책을 모두 기록 삭제
	}
}