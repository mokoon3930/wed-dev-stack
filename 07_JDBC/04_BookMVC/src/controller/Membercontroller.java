package controller;

import dao.MemberDAO;
import vo.Member;

public class Membercontroller {
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	// 4. 회원가입
	public void register(Member client) {
		// id가 primary key 에러가 납니다! 활용! -> 중복체크!
	}
	
	//5 . 로그인
	public Member login(String id, String pwd) {
		return null;
	}
	
	//6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴시 대여중인 책을 모두 기록 삭제
	}
	
}
