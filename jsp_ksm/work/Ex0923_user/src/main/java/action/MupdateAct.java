package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class MupdateAct
 */
@WebServlet("/member_update.do")
public class MupdateAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ori_idx = Integer.parseInt(request.getParameter("ori_idx"));
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put ("ori_idx", ori_idx);
		map.put ("name", name);
		map.put ("id", id);
		map.put ("pwd", pwd);
		map.put ("email", email);
		map.put ("addr", addr);
		
		MemberDao.getInstance().memberUpdate(map);
		response.sendRedirect("list.do");
		
	}

}
