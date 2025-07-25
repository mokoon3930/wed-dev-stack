package com.kh.upload.model.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class BoardDTO {
	
	private String title;
	private String content;
	private MultipartFile file;
}
