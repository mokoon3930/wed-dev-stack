package com.kh._abstract.step1;

public class BaskeBall extends Sports {

	public BaskeBall(int numOfPlayers) {
		super(numOfPlayers);
		
	}

	@Override
	public void rule() {
		System.out.println("BaskeBall의 선수는" +  this.numOfPlayers + "명, 공을 던져서 링에 넣는다");
	} 
	
}
