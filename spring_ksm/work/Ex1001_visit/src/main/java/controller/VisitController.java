package controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import vo.VisitVO;


@Controller
public class VisitController {
	
	//  HttpServletRequest request �޸� �Ҵ� �ڵ�����
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext app;
	
	/*
	 * @Autowired ServletContext app; //������Ʈ ������ ������ ��ü
	 * 
	 * @Autowired SqlSession sqlSession;
	 */
	
	VisitDAO visit_dao;
	
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	@RequestMapping(value= {"/", "list.do"})
	public String list(Model model) {
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list", list);
		return "visit/visit_list";
		
	}
	@RequestMapping("regi_visit.do")
	public String regiVisit() {
		return "/visit/visit_regi";
	}
	
	@RequestMapping("visit_insert.do")
	public String insert(VisitVO vo) {
		
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		//����÷�� ����
		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);//���� ���
		System.out.println("������" + savePath);
		
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		
		//���ε�� ������ ���� �Ѵٸ�
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename(); // ��¥�̸����� ��ȯ
			File saveFile = new File(savePath, filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
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
		
		int res = visit_dao.insertVisit(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("del_visit")
	@ResponseBody
	public String delVisit(int idx/* , String pwd */) {
		/*
		 * String result = "no"; 
		 * String setPwd = visit_dao.checkPwd(idx); 
		 * if(setPwd != null && setPwd.equals(pwd)){
		 *   int res = visit_dao.delVisit(idx);
		 * 
		 * if(res == 1) { //���� ���� �� result = "yes"; }
		 * 
		 * } System.out.println(result); return result;
		 */
		
		VisitVO vo = visit_dao.selectOne(idx);
		
		int res = visit_dao.delVisit(idx);
		
		String result = "no"; 
		if(res == 1) { 
			//���� ���� �� 
			result = "yes"; 
			
			if(!vo.getFilename().equals("no_file")) {
				String webPath = "/resources/upload/";
				String savePath = app.getRealPath(webPath);
				
				// "/resources/upload/abc.jpg"
				String filename = savePath + vo.getFilename();
				
				File file = new File(filename);
				if(file.exists()) {
					file.delete();
				}
			}
		}
			
		return result;
		
	}
	
	
	@RequestMapping("selectOne.do")
	public String selecteOne(int idx, Model model) {
		VisitVO vo = visit_dao.selectOne(idx);
		model.addAttribute("vo", vo);
	    return "visit/update_Visit";
	}
	
	@RequestMapping("visit_update.do")
	public String update(VisitVO vo) {
		
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = visit_dao.updateVisit(vo);
		return "redirect:list.do";
	}
	
	

	
	
}
