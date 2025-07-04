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
	
	public boolean checkId(String id) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHRER id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	
	// 4. 회원가입
	public void register(String id, String name, String pwd, int age) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, pwd);
		ps.setInt(4, age);
		ps.executeUpdate();
		
		return;
	}
	
	//5 . 로그인
	public boolean login(String id, String pwd) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id = ? AND pwd = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println("로그인 성공");
			return true;
		}
		System.out.println("로그인 실패");
		return false;
	}
	
	//6. 회원탈퇴
	public void delete(String id) {
		
	}

	public static MemberDAO getInstance() {
		
		return null;
	}

	
}