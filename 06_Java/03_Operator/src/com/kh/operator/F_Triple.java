package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	
	
	/*
	 * 삼항 연산자
	 * 
	 * 조전식 ? 값1 ; 값2
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 * - 조건식 결과과 true이면 값1을 반환한다.
	 * - 조건식 결과가 false이면 값2를 반환한다.
	 * */
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
		//f.method1();
		//f.practice2();
		f.practice3();
	}
	public void method1() {
		
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.println("정수값>> ");
		int number = sc.nextInt();
		
		String result = number > 0 ? "양수" : "음수";
		System.out.println(result);
		
		// +) 0인 겨우는 0입니다.
		result = number > 0 ? "양수" : number == 0 ? "0입니다" : "음수";
		System.out.println(result);
	}
	
	/*
	 * 문제 1
	 * 사용자 한테 두개의 정수 값을 입력받아서 두정수의 곱셈 결과가 100보다 크거나 같은 경우
	 * "결과가 100 이상입니다" 아닌경우 "결과가 100보다 작습니다" 출력
	 * */
	public void practice1() {
		System.out.println("첫번째 정수값>> ");
		int number1 = sc.nextInt();
		System.out.println("두번째 정수값>> ");
		int number2 = sc.nextInt();
		
		int numberA = number1 * number2;
		
		String result = numberA >= 100 ? "결과가 100 이상입니다" : "결과가 100보다 작습니다";
		System.out.println(result);
	}
	/*
	 * 문제 2
	 * 사용자한테 문자를 하나 입력 받아서 입력한 문자가 대문자이면 "알파벳 대문자 입니다"
	 * 소문자이면 "알파벳 소문자입니다", 둘 다 아니라면 "알파벳이 아니네요..."
	 * */
	public void practice2() {
		System.out.print("문자 입력해 주세요 >");
		char ch = sc.nextLine().charAt(0);
		
		String result = 'A' <= ch && ch <= 'Z' ? "알파벳 대문자 입니다" : 'a' <= ch && ch <= 'z' ? "알파벳 소문자입니다" : "알파벳이 아니네요..";
			System.out.println(result);
			
	}
	
	/*
	 * 문제 3!
	 * 사용자한테 숫자를 입력받아서 해당 숫자가 알파벳 범위안에 들어 간다면
	 * "알파벳 D입니다" 그게 아니면 "알파벳이 아닙니다"
	 * */
	
	public void practice3() {
		System.out.println("첫번째 정수값>> ");
		int num = sc.nextInt();
		boolean result ='A' <= num && num <= 'Z' || 'a' <= num &&  num <= 'z';
		System.out.println(result? "알파벳" + (char)num + "입니다" :"알파벳아 아닙니다");
		

		
	}
}	



















