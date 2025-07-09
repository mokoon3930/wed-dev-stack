package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;


@WebServlet("/search")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		
		try {
			Member member = dao.search(id);
			
			request.setAttribute("member", member);
			
			// /views/result.jsp 보넴
			request.getRequestDispatcher("/views/result.jsp").forward(request, response); 
		} catch (SQLException e) {
	
			
		}
		
		
	}

}
