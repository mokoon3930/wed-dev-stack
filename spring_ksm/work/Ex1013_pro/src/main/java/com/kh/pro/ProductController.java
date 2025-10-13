package com.kh.pro;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	public void setProduct_dao(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}
	
	
	@RequestMapping(value= {"/", "list.do"})
	public String list(String category, Model model) {
		
		// list.do?category=com001
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
		
		//������
		return "product/product_list";
		
	}//list
	
	//��� ��
	@RequestMapping("/product_regi_form.do")
	public String regi_form() {
		return "product/product_regi_form";
	}
	
	//���� ���
	@RequestMapping("/insert.do")
	public String insert( ProductVO vo) throws Exception {
		
		// ������ġ 
		String web_path = "/resources/images/";
		String path = app.getRealPath(web_path);
		System.out.println("������:" + path);
		
		//���ε� �� ���� ���� ��������
		MultipartFile photo1 = vo.getPhoto1();
		String filename1 = "no_file";
		
		if(!photo1.isEmpty()) {
			filename1 = photo1.getOriginalFilename();
			
			File saveFile = new File(path, filename1);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				filename1 = String.format("%d_%s", time, filename1);
				saveFile = new File(path, filename1);
			}
			
			photo1.transferTo(saveFile); // �������� ���������� ����
		}
		
		
		//ū ����
		MultipartFile photo2 = vo.getPhoto2();
		String filename2 = "no_file";
		
		if(!photo2.isEmpty()) {
			filename2 = photo2.getOriginalFilename();
			
			File saveFile = new File(path, filename2);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				filename2 = String.format("%d_%s", time, filename2);
				saveFile = new File(path, filename2);
			}
			
			photo2.transferTo(saveFile); // ū���� ���������� ����
		}
		
		//���� ������ vo�� ����
		vo.setP_image_s(filename1);
		vo.setP_image_l(filename2);
		
		
		//��ǰ ������ DB��
		product_dao.insert(vo);
		
		return "redirect:list.do?category="+vo.getCategory();
		
	}//insert
	
	
	
	//�� ���� ������
	@RequestMapping("/view.do")
	public String view(int idx, Model model) {
		
		
		ProductVO vo = product_dao.selectOne(idx);
		
		
		model.addAttribute("vo", vo);
		// ���ε��� vo�� ������ ����� jsp������
		return "/product/product_content";
	}
	
	
	// ��ǰ ���� ������
	@RequestMapping("product_one.do")
	public String selectOne(int idx, Model model) {
		
		ProductVO vo = product_dao.modfiy(idx);
		
		model.addAttribute("vo", vo);
		
		//������
		return "/product/product_modify";
	}
	
	
	
	// ��ǰ ����
	@RequestMapping("modify.do")
	public String updatePro(ProductVO vo) throws IllegalStateException, IOException {
		// ������ġ 
				String web_path = "/resources/images/";
				String path = app.getRealPath(web_path);
				System.out.println("������:" + path);
				
				//���� idx�� ���� ���� 1��
				ProductVO pro = product_dao.selectOne(vo.getIdx());
				
				//���ε� �� ���� ���� ��������
				MultipartFile photo1 = vo.getPhoto1();
				String filename1 = pro.getP_image_s();
				
				if(!photo1.isEmpty()) {
					filename1 = photo1.getOriginalFilename();
					
					File saveFile = new File(path, filename1);
					
					if(!saveFile.exists()) {
						saveFile.mkdirs();
					}else {
						long time = System.currentTimeMillis();
						filename1 = String.format("%d_%s", time, filename1);
						saveFile = new File(path, filename1);
					}
					
					photo1.transferTo(saveFile); // �������� ���������� ����
				}
				
				
				//ū ����
				MultipartFile photo2 = vo.getPhoto2();
				String filename2 = pro.getP_image_l();
				
				if(!photo2.isEmpty()) {
					filename2 = photo2.getOriginalFilename();
					
					File saveFile = new File(path, filename2);
					
					if(!saveFile.exists()) {
						saveFile.mkdirs();
					}else {
						long time = System.currentTimeMillis();
						filename2 = String.format("%d_%s", time, filename2);
						saveFile = new File(path, filename2);
					}
					
					photo2.transferTo(saveFile); // ū���� ���������� ����
				}
				
				//���� ������ vo�� ����
				vo.setP_image_s(filename1);
				vo.setP_image_l(filename2);
		
				
	
		
		product_dao.update(vo);
		
		return "product/product_list";
	}
	
	
}
