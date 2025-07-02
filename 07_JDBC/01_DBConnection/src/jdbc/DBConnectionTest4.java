package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			
			//드라이버 로딩
			Class.forName(p.getProperty("driver"));
			//디비연결
			Connection connect = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
			//PreparedStatement - DELETE (user_no)
			String query = "DELETE FROM user_info WHERE user_no = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, 3);
			
			//쿼리문 실행
			System.out.println(ps.executeUpdate() + "명 삭제");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
