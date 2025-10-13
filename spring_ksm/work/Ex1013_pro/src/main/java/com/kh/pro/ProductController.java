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
			// 강제로 com001로 잡음
			category = "com001";
		}
		
		//카테고리별 목록 조회
		List<ProductVO> list = product_dao.select(category);
		
		//바인딩
		model.addAttribute("list", list);
		
		//포워딩
		return "product/product_list";
		
	}//list
	
	//등록 폼
	@RequestMapping("/product_regi_form.do")
	public String regi_form() {
		return "product/product_regi_form";
	}
	
	//새글 등록
	@RequestMapping("/insert.do")
	public String insert( ProductVO vo) throws Exception {
		
		// 저장위치 
		String web_path = "/resources/images/";
		String path = app.getRealPath(web_path);
		System.out.println("절대경로:" + path);
		
		//업로드 된 파일 정보 가져오기
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
			
			photo1.transferTo(saveFile); // 작은사진 물리적으로 생성
		}
		
		
		//큰 사진
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
			
			photo2.transferTo(saveFile); // 큰사진 물리적으로 생성
		}
		
		//사진 정보를 vo에 저장
		vo.setP_image_s(filename1);
		vo.setP_image_l(filename2);
		
		
		//상품 정보를 DB로
		product_dao.insert(vo);
		
		return "redirect:list.do?category="+vo.getCategory();
		
	}//insert
	
	
	
	//상세 보기 페이지
	@RequestMapping("/view.do")
	public String view(int idx, Model model) {
		
		
		ProductVO vo = product_dao.selectOne(idx);
		
		
		model.addAttribute("vo", vo);
		// 바인딩된 vo를 가져가 사용할 jsp페이지
		return "/product/product_content";
	}
	
	
	// 상품 수정 페이지
	@RequestMapping("product_one.do")
	public String selectOne(int idx, Model model) {
		
		ProductVO vo = product_dao.modfiy(idx);
		
		model.addAttribute("vo", vo);
		
		//포워딩
		return "/product/product_modify";
	}
	
	
	
	// 상품 수정
	@RequestMapping("modify.do")
	public String updatePro(ProductVO vo) throws IllegalStateException, IOException {
		// 저장위치 
				String web_path = "/resources/images/";
				String path = app.getRealPath(web_path);
				System.out.println("절대경로:" + path);
				
				//파일 idx로 기존 파일 1개
				ProductVO pro = product_dao.selectOne(vo.getIdx());
				
				//업로드 된 파일 정보 가져오기
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
					
					photo1.transferTo(saveFile); // 작은사진 물리적으로 생성
				}
				
				
				//큰 사진
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
					
					photo2.transferTo(saveFile); // 큰사진 물리적으로 생성
				}
				
				//사진 정보를 vo에 저장
				vo.setP_image_s(filename1);
				vo.setP_image_l(filename2);
		
				
	
		
		product_dao.update(vo);
		
		return "product/product_list";
	}
	
	
}
