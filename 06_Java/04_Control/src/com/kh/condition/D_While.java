package com.kh.condition;

import java.util.Scanner;

public class D_While {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while 문
	 *  while (조건식) {
	 *  	조건이 true 일 경우 계속 실행
	 *  }
	 * */
	
	// 1~5 까지 출력
	public void method1() {
		int i = 1;
		while (i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	/*
	 * 무한루프 & break문
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는경우 break문이 포함되어 있는 반복문에서만 빠져나간다.
	 * 
	 * */
	public void method2() {
		while (true) {
			System.out.print("숫자입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			// 숫자가 0인경우 중지!
			if(num == 0) break;
			
		}
	}
	
	/*
	 * do{
	 * 		실행 코드 
	 * } while(조건식);
	 * - 조건과 상관없이 무조건 1번은 실행
	 * */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		}while(number == 0);
	}
	
	/*
	 * 숫자 맟치기 게임
	 * 검퓨터(random) 1과 100 사이의 값중에
	 * 저희가 맞히도록! 몇 번만에 끝내는지 출력!
	 * 해당 숫자보다 높으면 Up! 낮으면 Down!
	 * */
	
	public void method4() {
		System.out.print("숫자 입력해 주세요");
		int num = sc.nextInt();
		int min = 1;
		int max = 100;
		int count = 0;
		while (true) {
			++count;
			int random = (int) (Math.random() * (max-min+1) + min);
			if (random < num) {
				System.out.println(random + ", Up!");
				min = random + 1;}
			else if (random > num) {
				System.out.println(random + " , Down!");
				max = random - 1;}
			else {
				System.out.println(random + ", 정답!" + count + "회 만에 맞혔습니다.");
				break;
			}
		}
	}
	
	public void method5() {
		int random = (int) (Math.random() * 100 + 1);
		int count = 0;
		while (true) {
			System.out.println("숫자를 입력해주세요 >");
			int num = sc.nextInt();
			++count;
			if (random > num) {
				System.out.println(num + ", Up!");
			} else if (random < num) {
				System.out.println(num + " , Down!");
			} else {
				System.out.println(num + ", 정답!" + count + "회 만에 맞혔습니다.");
				break;
			}
		}
	}
	/*
	 * ---------------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ---------------------------------------
	 * 선택 > 1
	 * 예금액 > 10000
	 * ---------------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ---------------------------------------
	 * 선택 > 2
	 * 출금액 > 5000
	 * ---------------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ---------------------------------------
	 * 선택 3
	 * 잔고 확인> 5000
	 * ---------------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ---------------------------------------
	 * 선택 > 4
	 * 프로그램 종료
	 * */
	public void method6() {
		 int balance = 0;
		 boolean check = true;
		 while(check) {
		 System.out.println("--------------------------------");
		 System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		 System.out.println("--------------------------------");
		 System.out.print("선택 > ");
		 int select = sc.nextInt();
		 
		 if(select==1) {
			  System.out.println("예금액 > ");
			  balance += sc.nextInt();
		 } else if(select == 2) {
			 System.out.println("출금액 > ");
			 balance -= sc.nextInt();
		 } else if(select == 3) {
			 System.out.println("잔고 확인 > " + balance);
		 } else if(select == 4) {
			 System.out.println("프로그램 종료");
			 break;
		 }
		/*
		 switch(select) {
			 case 1:
				 System.out.println("예금액 > ");
				 balance += sc.nextInt();
				 break;
			 case 2:
				 System.out.println("출금액 > ");
				 balance -= sc.nextInt();
				 break;
			 case 3:
				 System.out.println("잔고 확인 > " + balance);
				 break;
			 case 4:
				 System.out.println("프로그램 종료");
				 check = false;
				 break;
		 }*/
		
		 //if(select == 4) break;
		
		}
		
	 }
				
		
	
	
	public static void main(String[] args) {
		D_While d = new D_While();
		d.method4();
	}

}





















