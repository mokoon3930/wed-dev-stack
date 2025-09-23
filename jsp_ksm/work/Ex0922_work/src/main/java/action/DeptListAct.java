package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DpDAO;

import vo.DpVO;


/**
 * Servlet implementation class deptListAct
 */
@WebServlet("/dept_list.do")
public class DeptListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//학생 목록 가져온다
				List<DpVO> list = DpDAO.getInstance().select();
				
				//list를 바인딩
				request.setAttribute("list", list);
				
				System.out.println("size :" + list.size());
				
				
				//포워딩
				RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp");
				disp.forward(request, response);
				
				// return "dept_list.jsp" 스프링 일떄 비슷한 부분
	}

}
