package com.kh.practice2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	private String title;
	private boolean coupon; // 블리언은 get / set 만드면 is로 찼아야함 ex) isCoupon
	private int accessAge;
	private int count; // 각 책 당 대여된 수(원래 이러게 X , 현재 재일 쉽게)
	
	public Book(String title, boolean coupon, int accessAge) {
		this.title = title;
		this.coupon = coupon;
		this.accessAge = accessAge;
	}
}
