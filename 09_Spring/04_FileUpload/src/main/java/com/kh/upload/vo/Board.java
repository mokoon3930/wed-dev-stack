package com.kh.upload.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class Board {
	
	private int no;
	private String title;
	private String content;
	private String url;
	private Date createdAt;
}
