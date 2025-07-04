package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;


public class Membercontroller {
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	
		
	
	
	// 4. 회원가입
		public String register(String id, String name, String pwd, int age) {
			try {
				boolean check = dao.checkId(id);
				if (check) {
					return "이미 정보가 있습니다.";
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "회원 가입 실패";
			
		}
	
	
	//5 . 로그인
	public boolean login(String id, String pwd) {
		try {
			return dao.login(id, pwd);
		} catch (SQLException e) {
			
			return false;
		}
		
	}
	
	//6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴시 대여중인 책을 모두 기록 삭제
	}


	public void register(Member member) {
	}


	
}
