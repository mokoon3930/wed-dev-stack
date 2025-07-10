package controller.component;

import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class SearchController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		Member member = dao.search(id);
		request.setAttribute("member", member);
		return new ModelAndView("/views/result.jsp");
	}
}
