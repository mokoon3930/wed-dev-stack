package com.kh._abstract.step2;

public class PineapplePizza extends Pizza{

	public PineapplePizza(int price, String brand) {
		super(price, brand);
		
	}

	@Override
	public void make() {
		System.out.println( this.brand +"의 불고기 피자는" + this.price +"원");
		System.out.println("피자 반죽과 함께 도우를 빛는다");
		System.out.println("토핑은 불고기 포함한다.");
		System.out.println("피자를 180도에서 10분간 굽는다.");
		System.out.println("피자를 8등분 한다.");
		System.out.println("피자를 포장 한다.");
	}
	
	public void info() {
	}
	public void topping() {
	}
}
	
