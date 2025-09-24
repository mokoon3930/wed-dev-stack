package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.MemberDao;

import vo.MemberVo;

/**
 * Servlet implementation class MemberOne
 */
@WebServlet("/member_one.do")
public class MemberOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		MemberVo vo = MemberDao.getInstance().memberOne(idx);
	
		
		request.setAttribute("vo", vo); // 바인딩
		
		// 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("update_form.jsp");
		disp.forward(request, response);
	}

}
