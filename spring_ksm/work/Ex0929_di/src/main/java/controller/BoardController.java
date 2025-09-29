package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

@Controller
public class BoardController {
	
	BoardService service;
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping( "list.do" )
	public String list( Model model) {
		List list = service.selectList();
		
		// list�� ���ε�
		model.addAttribute("list", list);
		
		// ������
		return "board_list";
	}
	
}
