package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	public MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	// 4. 회원가입
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
	
	//5 . 로그인
	public Member login(String id, String pwd) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			if(id.equals()) {
				
			}
		}
		
		return null;
	}
	
	//6. 회원탈퇴
	public void delete(String id) {
		
	}

	public static MemberDAO getInstance() {
		
		return null;
	}
	
}



















