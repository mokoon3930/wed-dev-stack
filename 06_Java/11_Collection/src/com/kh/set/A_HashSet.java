package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;

import com.kh.list.model.Person;

/*
 * Set 특징
 * - 중복 제거
 * - 순서 없음
 * */
public class A_HashSet {
	
	public void method1() {
		HashSet<String> set = new HashSet<>();
		set.add("전현무");
		set.add("박나래");
		set.add("기안84");
		set.add("키");
		set.add("박나래"); // 여러번 추가 해도 중복 제거!
	
		System.out.println(set);
		System.out.println("몇명이 들어 있나요?  " + set.size());
		System.out.println("기안84가 포함되어 있나요? " + set.contains("기안84"));
		
		set.remove("박나래"); // 삭제
		System.out.println(set);
		
		set.clear(); // 전체 삭제
		System.out.println("비어있는가? " + set.isEmpty());
	}
	
	public void method2() {
		HashSet<Person> set = new HashSet();
		set.add(new Person("전현무", "삼성동", 47));
		set.add(new Person("박나래", "이태원동", 39));
		set.add(new Person("기안84", "과천시", 40));
		set.add(new Person("키", "한남동", 33));
		set.add(new Person("키", "한남동", 33));
		
		// : 무슨 표시일까?(향상된 for 문)
		for(Person p : set) {
			System.out.println(p);
		}
		/*
		 * Iterator
		 * - 컬랙션에 저장된 요소를 접근하는데  사용하는 인터페이스
		 * - iterator()를 호출해서 Iterator를 구현하는 객체를 얻어서 사용
		 * */
		System.out.println("---------------");
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) { // 읽어올 요소가 있는지 확인 블리언 값
			System.out.println(it.next()); // 다음요소를 읽어옴
		}
		
		System.out.println(it.hasNext()); 
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		
		System.out.println(set);
	}
	
	
	public static void main(String[] args) {
		A_HashSet a = new A_HashSet();
		//a.method1();
		a.method2();
	}

}




















