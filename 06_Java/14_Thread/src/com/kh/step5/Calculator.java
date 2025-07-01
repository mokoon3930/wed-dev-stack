package com.kh.step5;

/*
 * 동기화 (synchronized)
 * - 스레드가 사용 중인 객체의 작업이 끝날 때까지 사용 중인 객체에 잠금을 걸어서 다른 스레드가 접근할 수 없도록
 * - 동기화 메서드가 객체내에 여러 개가 있을경우 스레드가 이들 중 하나를 실행하면 다른  tmfpemsms goekd tmfpemsms anffhsdlrh
 * */

public class Calculator {
	
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
