package com.kh.practice2.controller;

import com.kh.practice2.model.Snack;

public class SnackController {
	
	
	private Snack snack = new Snack();
	
	public String saveData(String kind, String name, String flavor, int numOf, int price ) {
		snack.setKind(kind);
		snack.setName("케이크");
		snack.setFlavor("블루베리");
		snack.setNumOf(1);
		snack.setPrice(15000);
		return "저장 완료 되었습니다";
	}
	
	public String confirmDate() {
		return snack.getKind() + "(" + snack.getName() + "-" + snack.getFlavor() + ")" + snack.getNumOf() + "개" + snack.getPrice() + "원";
	}
	
	
}
