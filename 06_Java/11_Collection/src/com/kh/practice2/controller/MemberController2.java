package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice2.model.Member;

public class MemberController2 {
		
		//전체 회원 목록
		private List<Member> members = new ArrayList<>();
		
		// 현재 로그인된 회원 (여러명인 경우가 힘드시담면)
		private Member member = null;
		
		//회원가입 및 로그인 처리
		public boolean registerAndLogin(String name, int age) {
			//회원가입  -> 회원 목록에 추가
			// members.add(new Member(name, age)); // 1번 방법
			for(Member member : members) {
				if (member.getName().equals(name) && member.getAge() == age){
					// 로그인 처리
					this.member = member;
					return true;
				}
				
				//동일 이름이 존재하면 가입 불가 처리 x
				if(member.getName().equals(name)) {
					return false;
				}
			}
			
			// 회원가입 + 로그인 처리
			Member m = new Member();
			m.setName(name);
			m.setAge(age);
			members.add(m);
			this.member = m;
			return true;
		}
		
		//로그 아웃
		public void logout() {
		 member = null;

		}
			
		
		// 마이페이지 - 현재 로그인된 정보
		public Member getMember() {
			return member;
		}
		// 회원 정보 수정 - 다시넣기
		public void setMember(Member member) {
			for (int i = 0; i < members.size(); i++) {
				Member m = members.get(i);
				if (m.getName().equals(member.getName())) {
					m = member;
					members.set(i, member);
				}
			}
			}
		
		

		
	}

