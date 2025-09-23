package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DpDAO;

/**
 * Servlet implementation class DeptDelAct
 */
@WebServlet("/dept_del.do")
public class DeptDelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		DpDAO.getInstance().delDept(deptno);
		
		response.sendRedirect("dept_list.do");
	}

}
