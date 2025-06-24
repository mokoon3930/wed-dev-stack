package com.kh.practice.controller;

import java.lang.reflect.Member;

public class Controller{
	
	int i = 0;
	Member[] members = new Member[i]; 
	public int count = 0;
	
	public Member[] getMembers() {
		return members;
	}
	public void setMembers(Member[] members) {
		this.members = members;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
		
	}

