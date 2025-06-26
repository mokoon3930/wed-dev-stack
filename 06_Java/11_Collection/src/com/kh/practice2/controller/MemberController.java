package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.model.Member;

public class MemberController {
	
	Scanner sc = new Scanner (System.in);
	//전체 회원 목록
	ArrayList<Member> members = new ArrayList<>();
	
	// 현재 로그인된 회원 (여러명인 경우가 힘드시담면)
	private Member member = null;
	
	//회원가입 및 로그인 처리
	public boolean registerAndLogin(String name, int age) {
		//동일 이름이 존재하면 가입 불가 처리 x
		//이름이랑 나이가 같은 경우 로그인 처리
		//기존에 해당하는 이름이 없다면 가입후 로그인 처리
		
		
		
		String inputname = sc.nextLine();
		int inputage = sc.nextInt();
		for(int i = 0; i < members.size(); i++) {
		if (name.equals(inputname)) {
			System.out.println("동일한 이름이 존재합니다. 가입이 불가합니다!");
			break;
		}else if (member.getName().equals(inputname) && member.getAge() == inputage) {
			System.out.println("로그인 성공");
			break;
		}else if (!member.getName().equals(inputname)) {
			System.out.println("회원가입 진행");
			System.out.println("이름 : ");
	    	String name1 = sc.next();
	    	System.out.println("나이 : ");
	    	int age1 = sc.nextInt();
	    	ArrayList<Member> members = new ArrayList<>();
	    	Member member1 = new Member();
	    	member.setName(name1);
	    	member.setAge(age1);
	    	members.add(member1);
		}
			
		}return false;
		
		
	}
	
	//로그 아웃
	public void logout() {
		int number = sc.nextInt();
		switch(number) {
		case 1: System.out.println("1. 마이페이지"); // 위의 메서들르 넣고 싶음
			break;
		case 2: System.out.println("2. 도서 대여하기");
			break;
		case 3: System.out.println("3. 로그아웃");
			break;
		default : System.out.println("4. 프로그램 종료");
		}
		
		
	}
	
	// 마이페이지 - 현재 로그인된 정보
	public Member getMember() {
		return null;
	}

	
}

























