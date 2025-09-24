package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class IdCheckAct
 */
@WebServlet("/check_id.do")
public class IdCheckAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MemberVo vo = MemberDao.getInstance().selectOne(id);
		
		String res = "no";
		
		if( vo == null) {
			// 가입이 가능한 id인 경우
			res = "yes";
		}
		
		// 결과를 callback메서드로 전달
		response.setContentType("text/plain;charset=UTF-8");
		String resultStr = String.format("[{'result':'%s', 'id':'%s'}]", res, id);
		
		//DB 사용을 마친 메서드를 콜백 메서드로 전달
		response.getWriter().println(resultStr);
	}

}
