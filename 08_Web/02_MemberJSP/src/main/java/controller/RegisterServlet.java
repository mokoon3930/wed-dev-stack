package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDAO;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. (있으면) 폼 값 받아온다
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		boolean check = true;
		ArrayList<Member> member = new ArrayList<>();
		
		//2. DAO호출 - DB접근 필요시
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			check = false;
		}
		
		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보내야 할 때
		//request.setAttribute("name", name);
		request.setAttribute("check", check);
		
		
		// 4. 네비게이션 : 결과 패이지를 지정
		// check 가 true 인 경우는 회원가입 성공
		// false인 경우는 실패 패이지로 -> fail.fsp
		//if (check) {
			// response.sendRedirect("result.jsp");
			// 만약 결과 페이지로 서버에서 받은 값을 보여주려면
			// -> RequestDispatcher forward 방식으로 보내야 함
		
			// 결과 페이지는 하나로! 
			request.getRequestDispatcher("result.jsp").forward(request, response);
		//}else {
		//	response.sendRedirect("fail.jsp");
		//}
	
	}
	
	public RegisterServlet() {
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
	

}























