package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController2 {

	// 선택사항 - 책 제목을 기준으로 현재 대여 인원 수 파악
	private Map<String, Integer> bookCount = new HashMap<>();
	
	MemberController2 mc = new MemberController2();
	
	// 책 대여
	public Object rentBook(Book book, Member member) {
		// 내 책 리스트
		ArrayList<Book> list = member.getBookList();
		// 1. 한사람당 대여할수 있는 책은 총 3권
		if(list.size() > 2) {
			return " 더 이상 대여할 수없습니다.";
		}
		
		// 2. 대여한 책(book)은 대여 불가능
		// 기존list 해당책이 있는 경우 대여 못하게 return
		if(list.contains(book)) {
			return "이미대여한 책입니다.";
		}
		
		// 3. 나이 제한이 걸려있은 책들 (쿠폰이 없는경우)
		if(member.getAge() < book.getAccessAge() && member.getCoupon() == 0) {
			return "대여가 불가능합니다";
		}
		// 5. 각 책들 마다 대여가 3권 까지만 (사람이 여러병인 경우)
		if (book.getCount() > 2) {
			return "더 이상 이책은 대여 할수 없습니다.";
		}
		
		// 대여가능 ---------------------------------------------!
		
		// Book 객체엥 count 추가한 방법
		book.setCount(book.getCount() + 1);
		
		// 책에 쿠폰이 있는경우 -> 내 쿠폰 하나 추가
		if(book.isCoupon()) {
			// 내쿠폰 수정 : 기존 내 쿠폰 가지고 있는 개수 + 1
			member.setCoupon(member.getCoupon() + 1);  
		}
		
		// 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능
		if(member.getAge() < book.getAccessAge()) {
			member.setCoupon(member.getCoupon() - 1);
			return "쿠폰으로 대여가 가능합니다"; // 쿠폰 사용 내 쿠폰 -1
		}
	
		
		//대여가능
		list.add(book); // 실질적으로 대여가 이루어 지는곳 이거 하나!
		member.setBookList(list);
		return member;
		
	}
}
