package com.kh.practice.controller;

import java.util.Arrays;

import com.kh.practice.model.RockPaperScissor;

public class RockPaperScissorcontroller {
	RockPaperScissor rpsModel = new RockPaperScissor();
	private int computer;
	
	return rpsModel.getRps()[computer];
	
	
	public void randomComputer ();
	// 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보
	int computer = (int)(Math.random() * 3);
	
	
	// 컴퓨터는 인덱스로 값을 찾음!
	return rpsModel.getRps()[computer];

}
 // 사용자가 입력한 값으로 인덱스 찾기
public void userIndex(String input) {
	return Arrays.asList(rpsModel.getRps()).indexOf(input)
}