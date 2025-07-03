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
	

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "INSERT INTO person( name, age, addr) VALUES(?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, "강성모");
			ps.setInt(2, 20);
			ps.setString(3, "오산시");
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	// person 테이블에 있는데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "SELECT * FROM person";
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + rs.getString("name") + rs.getInt("age") + rs.getString("addr"));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	// person 테이블에 있는데이터 전체 보여주기 - SELECT -> id로
	public void searchPerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "SELECT id FROM person";
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	// person 테이블 데이터 수정 - UPDATE
	public void updatePerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			
			
			
			ps.setString(1, "간성훈");
			ps.setInt(2, 10);
			ps.setString(3, "서울시");
			ps.setInt(4, 1);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	// person 데이블 데이터 삭제 - DELETE
	public void removePerson() {
		try {
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "DELETE FROM person WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, 2);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}


