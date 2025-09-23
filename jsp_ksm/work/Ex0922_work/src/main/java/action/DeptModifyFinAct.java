package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DpDAO;

/**
 * Servlet implementation class DeptModifyFinAct
 */
@WebServlet("/dept_modify_fin.do")
public class DeptModifyFinAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dept_modify_fin.do?
		
		int ori_deptno = Integer.parseInt(request.getParameter("ori_deptno"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put ("ori_deptno", ori_deptno);
		map.put ("deptno", deptno);
		map.put ("dname", dname);
		map.put ("loc", loc);
		
		DpDAO.getInstance().updateFin(map);
		response.sendRedirect("dept_list.do");
		
	}

}
