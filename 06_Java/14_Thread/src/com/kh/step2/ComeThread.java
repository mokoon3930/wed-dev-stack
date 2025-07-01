package com.kh.step2;
/*
 * 스레드 생성하는 방법 2
 * 1. Runnable 인터페이스 구현
 * 2. run() 메서드 오버 라이딩
 * 3. Thread 객체 생성시 생성자의 Runnable 인터페이스를 구현한 객체를 파라미터 값으로 전달 후 start() 후 메서드 호출
 * */
public class ComeThread implements Runnable{
	
	//스레드가 작동하는 부분
	@Override
	public void run() {
		
		for(int i = 0; i < 100; i ++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			System.out.println("CurrentThread : " + name + ", " + i);
		}
		
	}

}
