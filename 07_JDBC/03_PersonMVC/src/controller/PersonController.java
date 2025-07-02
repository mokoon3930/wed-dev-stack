package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class PersonController {
	
	// 리턴 타입 이나 파라미터는 자유롭게 변경 가능 !
	// 메서드 추가 가능
	
	public PersonController() {
		try {
			Class.forName(ServerInfo.DRIVER);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	// 고정적으로 반복 -- 디비연결 , (자원반납)
	//2. 디비연결
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		
		ps.close();		
		connect.close();
	}
	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		
		rs.close();
		close(ps, connect);
	}
	
	// ----------변동저인 반복 : DAO(Database Access Object)

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) throws SQLException {
		
			Connection connect = getConnect();
			String query = "INSERT INTO person( name, age, addr) VALUES(?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, "강성모");
			ps.setInt(2, 20);
			ps.setString(3, "오산시");
			ps.executeUpdate();
			
			close(ps, connect);
		
	}
	
	

	// person 테이블에 있는데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		try {
			Connection connect = getConnect();
			String query = "SELECT * FROM person";
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + rs.getString("name") + rs.getInt("age") + rs.getString("addr"));
			}
			close(rs, ps, connect);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}


	// person 테이블에 있는데이터 전체 보여주기 - SELECT -> id로
	public void searchPerson() {
		try {
			Connection connect = getConnect();
			String query = "SELECT id FROM person";
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
			}
			close(rs, ps, connect);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	// person 테이블 데이터 수정 - UPDATE
	public void updatePerson() {
		try {
			Connection connect = getConnect();
			String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			
			
			
			ps.setString(1, "간성훈");
			ps.setInt(2, 10);
			ps.setString(3, "서울시");
			ps.setInt(4, 1);
			ps.executeUpdate();
			
			close(ps, connect);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	// person 데이블 데이터 삭제 - DELETE
	public void removePerson() {
		try {
			Connection connect = getConnect();
			String query = "DELETE FROM person WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, 2);
			ps.executeUpdate();
			
			close(ps, connect);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}


