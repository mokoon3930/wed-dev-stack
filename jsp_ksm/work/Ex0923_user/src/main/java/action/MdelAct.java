package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class MdelAct
 */
@WebServlet("/member_del.do")
public class MdelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = MemberDao.getInstance().deleteMember( idx );
		
		String param ="no";
		if ( res > 0 ) {
			param = "yes";
		}
		System.out.println(param);
		String resultStr = String.format("[{'res':'%s'}]", param); // "[{\"res\":\"%s\"}]"
		response.getWriter().println(resultStr);
		
		//response.sendRedirect("list.do");
	}

}
