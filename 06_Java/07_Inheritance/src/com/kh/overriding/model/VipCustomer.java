package com.kh.overriding.model;

public class VipCustomer extends Customer{
	
	private double seleRatio; // 할인율

	
	public VipCustomer(String name) {
		this.name = name;
		this.grade = "VIP";
		this.bounsRatio = 0.1;
		this.seleRatio = 0.5;
	}
	

	public double getSeleRatio() {
		return seleRatio;
	}



	public void setSeleRatio(double seleRatio) {
		this.seleRatio = seleRatio;
	}
	
	/*
	 * 오버 라이딩 조건
	 *  - 부모 클래스의 메서드명, 메개변수, 리턴 타입 모두 동일
	 *  - 접근제어 좁은 범위로 변경 할수 없다
	 *  	-> 부모 클래스 매서드가 Protected라면, 범위가 넓은 protected나 pbulic 으로만 변경 가능
	 *  
	 *  @Override 어노테이션
	 *  - 명시 안 해줘도 오버라이딩
	 *  - 어노테이션을 붙이는 이유
	 *   - 해당 매서드가 오보라이딩 된 매서드라는 것을 컴파일에게 알려주는 역활
	 *   - 자식 매서드에서 재정의를 잘못한 경우 컴파일 에러 표시
	 * */
	
	@Override
	public void calc (int price) {
		this.bounsPoint = (int) (price * bounsRatio);
		this.price = (int) (price * seleRatio);
	}

	
	
	
}
