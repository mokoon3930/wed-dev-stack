package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.service.BoardService;

@Controller
public class BoardController {

    private final CustomErrorController customErrorController;

    BoardController(CustomErrorController customErrorController) {
        this.customErrorController = customErrorController;
    }
    
    @Autowired
    private BoardService service;
	
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
		System.out.println("파일이름 : " + file.getOriginalFilename());
		System.out.println("파일사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());
		
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
}


















