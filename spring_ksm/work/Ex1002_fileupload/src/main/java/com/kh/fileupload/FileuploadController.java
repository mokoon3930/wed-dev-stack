package com.kh.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileuploadController {

	@Autowired
	ServletContext app;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert_form() {
		return "insert_form";
	}
	
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo, Model model) {
		
		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);
		System.out.println("������ : " + savePath);
		
		//���ε�� ���� ���� 
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		
		//���ε带 ���� ������ �����Ѵٸ�
		if(!photo.isEmpty()) {
			
			//���ε�� ������ ���� ���ϸ�(���ε� �Ҷ� �Ѿ�� �̸�)
			filename = photo.getOriginalFilename();
			
			//������ ���� ���
			File saveFile = new File(savePath, filename);
				//exists File Ŭ�������� ���������� ���縦 �ϴ��� Ȯ��
			if(!saveFile.exists()) {
				//mkdir(s) ���������� ������ ���� (s)(2���� ����) 
				saveFile.mkdirs();
			}else {
				//������ ���ϸ��� �����Ѵٸ� ���� �ð��� �ٿ��� �ߺ��� ����
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			try {
				photo.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		vo.setFilename(filename);
		model.addAttribute("vo", vo);
		
		return "input_result";
		
	}
}
