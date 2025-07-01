package com.kh.step3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * ExecutorService - 스레드를 관리하는 도구
 * 
 * */
public class ExecuteTest {

	public static void main(String[] args) {
		
		// 1. ExecutorService 생성 - 스레드 풀을 만든다.
		ExecutorService execute = Executors.newCachedThreadPool();
		
		// 2. 작업 제출
		execute.submit(() -> {
			
		});
		execute.submit(null);
		
		// 3. ExecutorService 종료 요청
		execute.submit();
		
	}

}
