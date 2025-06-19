package com.kh.step1;

import com.kh.step1.model.Tv;

public class Application { // 메인 실행 클레스(객체 생성 테스트)
	
	/*
	 * 객체 (Object)
	 * - 현실 세계의 실제로 존재하는 사물이나 계념을 코드로 표현
	 * 
	 * 객체 지향 프로그레밍(OOP, Objected-Oriented Programming)
	 * - 개발하는 방법을 여개의 "객체"로 나누어 각 객체마다 각자의 역활을 가지도록 구성
	 * - 코드의 재사용성이 높고, 유지보수가 용이하고, 확장성이 뛰어남
	 * 
	 * OOP 특징
	 * 1. 추상화(Abstraction)
	 * 2. 캡슐화(Encapsulation)
	 * 2. 상속(Inheritance)
	 * 4. 다양성(Polymorphism)
	 * 
	 * OOP 원칙
	 * S: SRP(Single Responsibility Principle) - 단일 책임 원칙
	 * O: OCP(OPen/Closed Principle) - 개방 폐쇠 원칙
	 * L: LSP(Liskov Substitution Principle) - 리스코프 치환 원칙
	 * I: ISP(Interface Segregation principle) - 인터페이스 분리 원칙
	 * D: DIp(Dependency Inversion Principle) - 의존 역전 원칙
	 * 
	 * 클래스(Class)
	 * - 객체를 만들기 위한 설계도
	 * - 속성(Variable) + 기능(Method) 
	 * */

	public static void main(String[] args) {
		/*
		 * 객체 생성
		 * 
		 * 클래스명 변수명 = new 클래스명();
		 * - new 연산자를 사용해서 생성
		 * - new 연산자는 Heap 영역에 객체를 생성하고 객체의 주소값을 반환
		 * - 객체의 주소값을 참조 타입의 변수에 저장해서 객체 사용
		 * 
		 * */ 
		// 객체 생성 = 메모리에 올린다 = 객체의 구성요소(field, method)가 다 올라간다
		Tv tv = new Tv();
		System.out.println("TV 상태 : " + tv.power); // false - TV가 꺼진 상태
		tv.power(); // TV 켜기
		System.out.println("TV 상태 : " + tv.power); // true - TV가 켜진 상태
		
		System.out.println("TV 채널 : " + tv.channel); // 0
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelDown();
		tv.channelDown();
		tv.channelUp();
		tv.channelUp();
		System.out.println("TV 채널 : " + tv.channel); // 3
	}

}























