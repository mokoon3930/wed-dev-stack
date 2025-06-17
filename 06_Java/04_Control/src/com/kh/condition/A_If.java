package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * if 문
	 * 
	 * if (조건식) {
	 * 		조건식 참(true)일 때 실행
	 * } else {
	 * 		조건식이 false 일 때 실행
	 * }
	 * 
	 * - 보통 조건식에는 비교연산자나, 논리연사자를 주로 사용
	 * */
	
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다" 출력
		// 아니면 "불합격 입니다." 출력
		System.out.print("성적>> ");
		int score = sc.nextInt();
        /*if  (score >= 60) {
        	System.out.println( "합격입니다" );}
        else {System.out.println( "불합격입니다" );}*/
      
        if  (score >= 60)System.out.println( "합격입니다" );
        else System.out.println( "불합격입니다" );
        
        //삼항연산자
        System.out.println(score >= 60 ? "합격입니다" : "불합격입니다" );
	}
	public void method2() {
		// 본인의 이름을 입력했으때 본인이면 "본인이다", 아니면 "본인이 아니다" 출력
		System.out.print("본인이름>");
		String Name = sc.nextLine();
		
		
		if(Name.equals("강성모")) {System.out.println("본인이다");}
		else {System.out.println("본인이 아니다");}
	}
	
	/*
	 * if - else if - else 문
	 * 
	 * if(조건식1) {
	 * 		조건식1 참(true)일 때 실행
	 * }else if(조건식2) {
	 * 		조건식1이 거짓 (false)이면서 조건식2 참(true)일 때 실행
	 * }else{
	 * 		조건식1, 조건식2 모두 거짓(false)일때 실행
	 * }
	 * 
	 * - else if는 수가 제한이 없다.
	 * */
	
	/*
	 * 사용자에게 점수 (0~100)를 입력받아서 점수별로 등급 출력
	 * - 90점 이상은 A 등급
	 * - 90점 미만 80 이상은 B 등급
	 * - 80점 미만 70 이상은 C 등급
	 * - 70점 미만 60 이상은 D 등급
	 * - 60점 미만 F 등급
	 * */
	public void method3() {
		System.out.print("점수를 입력하세요 ");
		int score = sc.nextInt();
		char grade = '\u0000';
		
		if(score < 0 || score > 100) {
			System.out.println("잘못 입력 하셨습니다");
			return;
		}
		else if	(score >= 90) grade = 'A';
		else if (score >= 80) grade = 'B';
		else if (score >= 70) grade = 'C';
		else if (score >= 60) grade = 'D';
		else grade = 'F';
		System.out.println(grade + " 등급");
		
		
		/*if (score >= 90) {System.out.println("A 등급 입니다");}
		else if (score >= 80) {System.out.println("B 등급 입니다");}
		else if (score >= 70) {System.out.println("C 등급 입니다");}
		else if (score >= 60) {System.out.println("D 등급 입니다");}
		else {System.out.println ("F 등급 입니다");}*/
	}
	
	/*
	 * 세 정수를 입력했을때 짝수만 출력
	 * 
	 * num1 입력 : 3
	 * num2 입력 : 4
	 * num3 입력 : 8
	 * 4
	 * 8
	 * 
	 * */
	public void method4() {
		System.out.print("num1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("num2 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("num3 입력 : ");
		int num3 = sc.nextInt();
		
		if(num1 % 2 == 0)System.out.println(num1);
		if(num2 % 2 == 0)System.out.println(num2);
		if(num3 % 2 == 0)System.out.println(num3);
		
	}
	
	
	public static void main(String[] args) {
		A_If a = new A_If();
		//a.method1();
		//a.method2();
		//a.method3();
		a.method4();
	}

}


















