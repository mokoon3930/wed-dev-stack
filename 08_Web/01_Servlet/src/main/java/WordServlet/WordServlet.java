package WordServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/word")
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 방식으로 호출");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 방식으로 호출!");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩 필수! 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		System.out.println("service 호출!");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>" + keyword +  "</h1>");
		out.println("</bodt></html>");
		
		out.close();
		
		
	}
	
	
	
	

}
