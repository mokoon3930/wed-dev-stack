package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	private Scanner scanner;
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		v.method1();
		v.method2();
		v.method3();
		v.method4();
		v.method5();
		v.method6();
		v.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		int a = 10000;
		int s = 7000;
		
		System.out.println(a * 2 + s * 3);
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		// 코드 적어주세요!
		System.out.printf("x = %d\n", y);
		System.out.printf("y = %d\n", z);
		System.out.printf("z = %d\n", x);
	}
	

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		this.scanner = new Scanner(System.in);
		System.out.print("첫 번쨰 정수 : ");
		int f = scanner.nextInt();
		System.out.print("두 번쨰 정수 : ");
		int s = scanner.nextInt();
		
		int P = (f + s);
		int M = (f - s);
		int X = (f * s);
		int D = (f / s);
		
		
		System.out.printf("더하기 : %d\n", P);
		System.out.printf("빼기 : %d\n", M);
		System.out.printf("곱하기 : %d\n", X);
		System.out.printf("나누기 몫 : %d\n", D);
		
		
		
		
	}

	/*
	 * 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		System.out.print("가로: ");
		double W = scanner.nextDouble();
		System.out.print("세로: ");
		double H = scanner.nextDouble();
		
		double A = W * H;
		double P = (W + H) * 2;
		
		System.out.printf("면적 : %.2f\n", A);
		System.out.printf("둘레 : %.1f\n", P);
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		this.scanner = new Scanner(System.in);
		System.out.print("첫번쨰 문자: ");
		String A1 = scanner.next();
		System.out.print("두번쨰 문자: ");
		String A2 = scanner.next();
		System.out.print("마지막 문자: ");
		String A3 = scanner.next();
		
		System.out.printf("%s%s%sl%s", A1, A1, A2, A3);
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		
	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		this.scanner = new Scanner(System.in);
		System.out.print("국어 : ");
		int i1 = scanner.nextInt();
		System.out.print("영어 : ");
		int i2 = scanner.nextInt();
		System.out.print("수학 : ");
		int i3 = scanner.nextInt();
		
		int S1 = (i1 + i2 + i3);
		double M1 = (S1 / 3);
		
		System.out.printf("총점 : %d\n", S1);
		System.out.printf("평균 : %.3f\n", M1);
	}

}