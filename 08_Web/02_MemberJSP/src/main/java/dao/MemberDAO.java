package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	
	
	public MemberDAO() {
		try {
			//1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection connect() throws SQLException {
		// 2. 디비 연결
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/work","root","qwer1234");
	}
	
	// 회원 가입
	public void register(Member member) throws SQLException {
		
		Connection connect = connect();
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		ps.executeUpdate();
	}




	

	
}




























