package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class Membercontroller {
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	
	
	// 4. 회원가입
	
		
	public Object register(String id, String name, String pwd, int age) {
		// id가 primary key 에러가 납니다! 활용! -> 중복체크!
		try {
			boolean check = dao.checkId(id, name);
			if(check) {
				System.out.println("이미 정보가 있습니다");
				return null;
			}
			
			return dao.register(id, name, pwd, age);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
