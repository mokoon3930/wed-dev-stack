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
import vo.MemberVo;

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
		request.setCharacterEncoding("utf-8"); // post 방식으로 한글을 넘기면 인코딩 해주기
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		// Map 은 스프링에 DTO 개념이랑 비슷함 아래는 vo랑 똑같은 DTO만든 의미
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put ("idx", idx);
//		map.put ("name", name);
//		map.put ("id", id);
//		map.put ("pwd", pwd);
//		map.put ("email", email);
//		map.put ("addr", addr);
		
		MemberVo vo = new MemberVo();
		vo.setIdx(idx);
		vo.setName(name);
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setAddr(addr);
		
		
		MemberDao.getInstance().memberUpdate(vo);
		response.sendRedirect("list.do");
		
	}

}
