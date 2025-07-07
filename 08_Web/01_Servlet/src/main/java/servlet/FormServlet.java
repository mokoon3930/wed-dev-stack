package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인코딩 필수 한글 처리 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menu = request.getParameterValues("menu");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(gender);
		System.out.println(Arrays.toString(menu));
		
		gender = gender.equals("M") ? "남자" : "여자";
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>아이디 : " + id + "</h2>");
		out.println("<h2>비밀번호 : " + pwd + "</h2>");
		out.println("<h2>성별 : " + gender + "</h2>");
		//out.println("<h2>좋아하는 메뉴 : " + String.join(",", menu) + "</h2>");
		
		if (menu != null) {
			out.println("<h2> 좋아하는 메뉴</h2>");
			out.println("<ul>");
			for (String m : menu) {
				out.println("<li>" + m + "</li>");
			}
			out.println("</ul>");
		}

		out.println("</bodt></html>");

		out.close();
	}
}
