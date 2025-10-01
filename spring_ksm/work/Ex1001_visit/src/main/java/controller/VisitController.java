package controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDAO;
import vo.VisitVO;


@Controller
public class VisitController {
	
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
		int res = visit_dao.insertVisit(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("del_visit")
	@ResponseBody
	public String delVisit(int idx, String pwd) {
		String result = "no";
		String setPwd = visit_dao.checkPwd(idx);
		if(setPwd != null && setPwd.equals(pwd)) {
			int res = visit_dao.delVisit(idx);
			
			if(res == 1) {
				//삭제 성공 시
				result = "yes";
			}
			
		}
		System.out.println(result);
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
		int res = visit_dao.updateVisit(vo);
		return "redirect:list.do";
	}
	
	

	
	
}
