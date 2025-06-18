package com.kh.Prectice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
		//o.method1();
		//o.method2();
		//o.method3();
		//o.method4();
		//o.method5();
		//o.method6();
		//o.method7();
		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("연필 개수 : ");
		int pen = sc.nextInt();
		System.out.print("인원 수 : ");
		int P = sc.nextInt();
		
		if (pen < P) {System.out.println("인원수가 너무 많습니다");}
		else if (pen % P == 0)System.out.println(pen / P + "개씩 골고루 나눠가졌습니다.");
		else if (pen % P != 0)System.out.println(pen / P + "개씩 나눠가지고 " + pen % P + " 개 남았습니다");
		
	}
	
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("3자리 숫자를 입력하시오");
		int A = sc.nextInt();
		int A1 = A / 100;
		int A2 = A1 * 100;
		
		System.out.printf("%d", A2);
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("1번 수");
		int A1 = sc.nextInt();
		System.out.print("2번 수");
		int A2 = sc.nextInt();
		System.out.print("3번 수");
		int A3 = sc.nextInt();
		
		String result =  A1 == A2 && A2 == A3 ? "true" : "false";
		System.out.println(result);
	}
	

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.print("1번 수");
		int A1 = sc.nextInt();
		
		String result =  A1 % 2 == 0 ? "짝수" : "짝수가 아니다";
		System.out.println(result);
		//System.out.println(A1 % 2 == 0 ? "짝수" : "짝수가 아니다"); - 이것도 가능
	}	

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.print("주민번호를 입력 하시오 : ");
		String no = sc.nextLine();
		char noChar = no.charAt(7);
		
		//String result =  noChar % 2 == 0 ? "여자" : "남자";
		//System.out.println(result);
		System.out.println(noChar % 2 == 0 ? "여자" : "남자");
		
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.print("나이를 입력하시오");
		int age = sc.nextInt();
		System.out.println(age <= 19 ? "청소년" : age <= 13 ? "어린이" : "성인" );
		/*
		if (age <= 13) System.out.println("어린이");
		else if (age <= 19) System.out.println("청소년");
		else {System.out.println("성인");}
		*/
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.print("사과의 개수");
		int A = sc.nextInt();
		System.out.print("바구니 크기");
		int P = sc.nextInt();
		int I = (A / P);
		int I1 = (A % P);
		
		
		if (I1 != 0) {System.out.println(I + 1);}
		else {System.out.println(I);}
		
		}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		System.out.print("시간");
		int H = sc.nextInt();
		System.out.print("분");
		int M = sc.nextInt();
		System.out.print("초");
		int S = sc.nextInt();
		
		System.out.printf("%d시간 %d분 %d초" , H, M, S);
		
		int second = 3600;
		int hour = second / 3600;
		second = second - hour * 3600;
		//second -= hour * 3600;
		int minute = second / 60;
		second = second - minute *60;
		//second -= minute *60;
		System.out.println(hour + "시간 " + minute + "분 " + second + "초");
	}
	
	
}











