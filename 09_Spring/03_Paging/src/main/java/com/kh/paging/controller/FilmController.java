package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.paging.model.vo.Film;
import com.kh.paging.service.FilmService;

@Controller
public class FilmController {
	
	@Autowired
	private FilmService service;
	
	@GetMapping("/")
	public String showFilm(Model model) {
		model.addAttribute("list", service.showFilm());
		return "/list";
	}
	
	
	
}
