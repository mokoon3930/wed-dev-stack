package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

public String search(String id) throws SQLException {
	Connection connect = connect();
	String query = "SELECT * FROM member WHERE id = ? ";
	PreparedStatement ps = connect.prepareStatement(query);
	ps.setString(1, id);
	ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		return rs.getString("id");
	}
	return "조회된 아이디가 없습니다";
	
}

public ArrayList<Member> allMember() throws SQLException {
	Connection connect = connect();
	String query = "SELECT * FROM member";
	PreparedStatement ps = connect.prepareStatement(query);
	ResultSet rs = ps.executeQuery();
	
	ArrayList<Member> list = new ArrayList<>();
	while(rs.next()){
		Member member = new Member();
		member.setId(rs.getString("id"));
		member.setPwd(rs.getString("pwd"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
	}
	return list;
}


	
}




















