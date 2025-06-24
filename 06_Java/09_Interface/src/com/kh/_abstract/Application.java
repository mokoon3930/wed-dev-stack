package com.kh._abstract;

import com.kh._abstract.step1.BaskeBall;
import com.kh._abstract.step1.FootBall;
import com.kh._abstract.step1.Sports;
import com.kh._abstract.step2.BulgogiPizza;
import com.kh._abstract.step2.PineapplePizza;
import com.kh._abstract.step2.Pizza;
import com.kh._abstract.step2.PotatoPizza;

public class Application {

	/*
	 * 추상 클래스(Abstract Class)
	 * - 미완성 클래스오 추상 메서드를 포함한 클래스
	 * - 미완성 클래스이기 때문에 new 연산자를 통해서 객체 생성 X
	 * - 일반적인 필드, 매서드 포함 (변수 + 메서드 + 추상 메서드)
	 * - 객체 생성헐수 없지만 참조형 변수 타입으로 사용가능
	 * - 상속 관계로 다양성 적용 가능
	 * 
	 * 추상 매서드 (Abstract Method)
	 * - 미완성 메서드로 중괄호({})가 구현 되지 않는 메서드
	 * - 추상 클래스 상속받는 자식 클래스에서 "반드시" 오버라이딩 (재정의)
	 * - 오버라이딩(재정의) 해주지 않은면 에러
	 * - 자식 클래스의 강제성 부여
	 * */
	public static void main(String[] args) {
		// 추상클래스 여서 객체 생성 X
		//Sports s = new Sports(5);
		//다형성으로 인해서 부모타입 가능!
		Sports b = new BaskeBall(9);
		Sports f = new FootBall(11);
		
		b.rule();
		f.rule();	
		
		Pizza[] pizza = {
				new BulgogiPizza(1000, "피자헛"),
				new PotatoPizza(2000, "파파존스"),
				new PineapplePizza(300, "도미노"),
		
	}
		

	public void make() {
			
			
	
			for(Pizza p : pizza) {
				System.out.println();
				p.make();
			}
		

		
		/*
		 * 브랜드,가겨 자유롭게, 세가지 피자는 다 사용!
		 * 
		 * 해다 브랜드의 포테이토 피자는 가격 ~원
		 * 피자 반죽과 함께 도우를 빛는다.
		 * 토핑은 포테이토 포함한다.
		 * 피자를 180도에서 10분간 굽는다.
		 * 피자를 8등분 한다.
		 * 피자를 포장 한다.
		 * 
		 * */
	
		/*
		 * 브랜드,가겨 자유롭게, 세가지 피자는 다 사용!
		 * 
		 * 해다 브랜드의 파인에플 피자는 가격 ~원
		 * 피자 반죽과 함께 도우를 빛는다.
		 * 토핑은 파인에플 포함한다.
		 * 피자를 180도에서 10분간 굽는다.
		 * 피자를 8등분 한다.
		 * 피자를 포장 한다.
		 * 
		 * */
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
