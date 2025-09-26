package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductModify
 */
@WebServlet("/modify.do")
public class ProductModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장위치 
		String web_path = "/images";
		ServletContext app = request.getServletContext();
		String path = app.getRealPath(web_path);
		
		int max_size = 1024 * 1024 * 100;
		
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		//파일 이외의 나머지 파라미터들 수신
		int idx = Integer.parseInt(mr.getParameter("idx"));
		String category = mr.getParameter("category");
		String p_num = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_company = mr.getParameter("p_company");
		String p_content = mr.getParameter("p_content");
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
		String p_image_s = mr.getFilesystemName("p_image_s"); // 작은 이미지
		String p_image_l = mr.getFilesystemName("p_image_l"); // 큰 이미지
		
		ProductVO vo = new ProductVO();
		vo.setIdx(idx);
		vo.setCategory(category);
		vo.setP_num(p_num);
		vo.setP_name(p_name);
		vo.setP_company(p_company);
		vo.setP_content(p_content);
		vo.setP_price(p_price);
		vo.setP_saleprice(p_saleprice);
		vo.setP_image_s(p_image_s);
		vo.setP_image_l(p_image_l);
		
		
		ProductDAO.getInstance().update(vo);
		
		response.sendRedirect("list.do?category="+category);
	}

}

























