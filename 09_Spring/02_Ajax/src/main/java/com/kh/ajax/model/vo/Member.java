package com.kh.ajax.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class Member {
	
	private String id;
	private String name;
	private String pwd;
	private int age;
}
