package com.kh.condition;

import java.lang.annotation.Target;
import java.util.Random;
import java.util.Scanner;

public class C_For {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * for문
	 * 
	 * for (초기식; 조건식; 증감식){
	 * 		실행코드
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문
	 * - 초기식 : 반복문이 수행될 때 단 한번만 실행, 반복문 안에서 사용할 변수 선언하고 초기값 대입
	 * - 조건식 : 결과가 true이면 실행 코드를 실행, false이면 실행하지 않고 반복문을 빠져나감
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연사자 사용
	 * */
	// 1~5 출력
	public void method1() {
		
		for (int i = 1; i <= 5; i++) {
		System.out.println(i);}
	}	
	// 1~5반대로 출력
	public void method2() {
		for(int A = 5; A >= 1; A--) {
			System.out.println(A);
		}
	}
	// 1 ~ 10 사이의 홀수만 출력
	public void method3() {
		for(int i = 1; i <= 10; i+=2) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 != 0)
			System.out.println(i);
		}
		
		System.out.println();
		
		/*
		 * continue문 
		 * - continue문은 반복문 안에서 사용
		 * - 반복문을 만나면 continue를 만나면 "현재 구문" 종료
		 * - 반복문을 빠져나가는 건 아님! 가음 반복 수행
		 * */
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) continue;
			System.out.println(i);
		}
		
	}
	
	//1~10 까지 합계
	public void method4(){
		int A = 0;
		for(int i = 1; i <= 10; i++){
			A += i;
			
		}
		System.out.println(A);
	}
	// 1 부터 사용자가 입력한 수까지 합계
	public void method5() {
		int A = 0;
		System.out.print("수를 입력해 주세요");
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++){
			A += i;
			
		}
		System.out.println(A);
	}
	
	// 1부터 랜덤값(2 ~ 10) 까지 합계
	public void method6() {
		int random = (int)(Math.random() * 9 + 2); // 0.0 <=  random < 1.0 
		Random random2 = new Random();
		int random3 = random2.nextInt(9) + 2; // 2 ~ 10 까지
		int random4 = random2.nextInt(2, 11);
		
		int A = 0;
		
		for(int i = 1; i <= random; i++){
			A += i;
			
		}
		System.out.println(A);
	}
	
	/*
	 * 사용자한테 입력 받은 문자열을 세로로 출력
	 * 사용자 입력 > hello
	 * h -> "hello".charAt(0)
	 * e
	 * l
	 * l
	 * o ->""hello".charAt("hello".length()-1)
	 * */
	public void method7() {
		System.out.println("사용장 입력");
		String word = sc.nextLine();
		
		for(int i = 1; i <= word.length(); i++) {
			System.out.println(word.charAt(i));
		}
		
		/*
		 * 향상된 for문
		 * for(데이터 타입 변수 : 배열) {
		 * 		변수 : 배열의 값을 하나씩 가지고 옴
		 * }
		 * 문자열 : 문자의 배열, 여러개의 문자가 배열을 이룬 것이 문자열
		 * - ToCharArray : 모든 문자가 들어 있는 Char[] 형식의 데이터 반환
		 * - charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환
		 * */
		char[] arr = word.toCharArray();
		for (char ch : arr) {
			System.out.println(ch);
		}
	}
	

	public void method8() {
		for(int j = 0; j < 4; j++) {
			for (int i = 0; i < 5; i++) {
				System.out.print("*");}
			System.out.println();
		}
		
		
	}
	
	
	/*
	 * 1**** : (i, j)
	 * *2***
	 * **3**
	 * ***4*
	 * ****5
	 * 
	 * */
	public void method9() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				//System.out.print("("+ i +","+ j +")");
				if (i == j)System.out.print(i);
				else System.out.print("*");
			}
			System.out.println();

		}
	}
	/*
	 * *
	 * **
	 * ***
	 * ****
	 * *****
	 * */
	public void method10() {
		for(int j = 0; j < 5; j++) {
			for (int i = 0; i <= j; i++) {
			 System.out.print("*");
				//System.out.print("("+ i +","+ j +")");
				}
			System.out.println();
		}
	}
	/*
	 *     * i = 4, j = 1
	 *    ** 
	 *   ***
	 *  ****
	 * *****  
	 * */
	public void method11() {
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= 0; j--) {
				if (i < j)
					System.out.print(" ");
				else
					System.out.print("*");
				// System.out.print("("+ i +","+ j +")");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		C_For c = new C_For();
		c.method11();
	}

}
	
	




















