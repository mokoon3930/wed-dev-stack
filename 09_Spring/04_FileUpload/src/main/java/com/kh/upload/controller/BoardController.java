package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class BoardController {

    private final CustomErrorController customErrorController;

    
    @Autowired
    private BoardService service;

    BoardController(CustomErrorController customErrorController) {
        this.customErrorController = customErrorController;
    }
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	public String fileUpload(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" +file.getOriginalFilename();
		
		File copyFile = new File("\\\\192.168.0.35\\upload\\" + fileName);
		
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return fileName;
		
	}
	
	@PostMapping("/Upload")
	public String upload(MultipartFile file) {
		// 중복 방지를 위한 UUID 적용
		
		String fileName = fileUpload(file);
		// http://localhost:8081/ + fileName <- url
		
		return "redirect:/";
	}
	
	// List<MultipartFile>
	
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> file) {
		for(MultipartFile files : file) {
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" +files.getOriginalFilename();
			
			File copyFile = new File("\\\\192.168.0.35\\upload\\" + fileName);
			
			try {
				files.transferTo(copyFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardDTO> list = service.selectAll();
		model.addAttribute("list", list);
		return "list";
		
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		System.out.println(dto.getFile());
		
		// 이미지 업로드 추가
		String fileName = fileUpload(dto.getFile());
		
		// board 테이블에 데이터 추가
		
		Board vo = new Board();
		vo.setTitle(dto.getTitle());
		vo.setContent(dto.getContent());
		vo.setUrl(fileName);
		service.insert(vo);
		
		System.out.println(vo);
	
		return "redirect:/view?no" + vo.getNo();
	}
	
	// /view?no=${board.no} -> view.jsp 데이터 보여줘야지
	
	@GetMapping("/view")
	public String view(int no, Model model) {
		System.out.println(no);
		Board board = service.select(no);
		model.addAttribute("board", board);
		
		
		return "view";
	}
}


















