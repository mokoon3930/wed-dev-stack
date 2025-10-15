package controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.ProductDAO;
import vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	ServletContext app;

	ProductDAO product_dao;
	
	public ProductController(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}
	
	@RequestMapping(value= {"/", "/list.do"})
	public String ProductList(String category, Model model) {	
		//list.do <-- null
		//list.do?category= <--- empty
		if( category == null || category.isEmpty() ) {
			// ������ com001�� ����
			category = "com001";
		}
		
		//ī�װ��� ��� ��ȸ
		List<ProductVO> list = product_dao.select(category);
		
		//���ε�
		model.addAttribute("list", list);
		
		return "product/product_list";
		
	}
	
	@RequestMapping("product_regi.do")
	public String ProductRegi() {
		return "product/product_regi_form";
		
	}
	
	@RequestMapping("insert.do")
	public String ProductInsert(ProductVO vo) {
	String web_path = "/images";
	String savePath = app.getRealPath(web_path);
	
	//System.out.println("������:" + path);
	
	/*
	 * //�ִ� ���ε� �뷮 int max_size = 1024 * 1024 * 100;
	 */
	MultipartFile photoS = vo.getP_image_s();
	MultipartFile photoL = vo.getP_image_l();
	
	
	
	
	/*
	//���� �̿��� ������ �Ķ���͵� ����
	String category = mr.getParameter("category");
	String p_num = mr.getParameter("p_num");
	String p_name = mr.getParameter("p_name");
	String p_company = mr.getParameter("p_company");
	String p_content = mr.getParameter("p_content");
	
	int p_price = Integer.parseInt(mr.getParameter("p_price"));
	int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
	
	ProductVO vo = new ProductVO();
	vo.setCategory(category);
	vo.setP_num(p_num);
	vo.setP_name(p_name);
	vo.setP_company(p_company);
	vo.setP_content(p_content);
	vo.setP_price(p_price);
	vo.setP_saleprice(p_saleprice);
	vo.setP_image_s(p_image_s);
	vo.setP_image_l(p_image_l);
	
	System.out.println(vo.toString());
	//��ǰ ������ DB��
	ProductDAO.getInstance().insert(vo);
	
	response.sendRedirect("list.do?category="+category);
	
	}	*/
}
}
