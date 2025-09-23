package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DpDAO;

import vo.DpVO;


/**
 * Servlet implementation class deftRegiAct
 */
@WebServlet("/dept_register.do")
public class deftRegiAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname") ;
		String loc = request.getParameter("loc") ;
		
		System.out.println(dname);
		System.out.println(loc);
		
		DpVO vo = new DpVO();
		vo.setDeptno(deptno);
		vo.setDname(dname);
		vo.setLoc(loc);
		
		
		
		DpDAO.getInstance().register(vo);
		
		// return "redirect:list.do";
		response.sendRedirect("list.do");
	}

}
