package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

public class LogoutController implements Controller{
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(); // 로그인 정보는 세션에 담겨있음
		Member member = (Member) session.getAttribute("member");
		if(member!=null) {
			session.invalidate();
		}
		return new ModelAndView("index.jsp", true);
	}
}
