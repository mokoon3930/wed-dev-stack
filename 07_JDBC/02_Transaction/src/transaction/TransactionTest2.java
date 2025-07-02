package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class TransactionTest2 {
	
	
	/*
	 * 지은 -> 지연 : 3만원씩 이체
	 * 지은님의 잔액이 마이너스가 될 경우 이체 취소!
	 * UPDATE 2개, SELECT 1개
	 * */
	public static void main(String[] args) {
		
		try {
			Class.forName(ServerInfo.DRIVER);
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			connect.setAutoCommit(false);
			
			String query1 = "UPDATE bank SET balance = balance + ? WHERE name = ? ";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			ps1.setInt(1, 30000);
			ps1.setString(2, "지연");
			
			ps1.executeUpdate();
			
			String query2 = "UPDATE bank SET balance = balance - ? WHERE name = ? ";
			PreparedStatement ps2 = connect.prepareStatement(query2);
			ps2.setInt(1, 30000);
			ps2.setString(2, "지은");
			
			ps2.executeUpdate();
			
			String query3 = "SELECT balance FROM bank WHERE name = ?";
			PreparedStatement ps3 = connect.prepareStatement(query3);
			ps3.setString(1, "지은");
			
			ResultSet rs = ps3.executeQuery();
			
			if(rs.next()) {
				if (rs.getInt("balance") < 0) {
					//잔액이 없음 -> 이채 취소
					System.out.println("금액이 없는 경우 돈을보낼수 없습니다");
					connect.rollback();
				}else {
					System.out.println("금액이 있어 이채를 합니다");
					connect.commit();
				}
			}
			
			connect.setAutoCommit(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
