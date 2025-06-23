package com.kh.praction2.view;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;

public class SnackView {
	
	Scanner sc = new Scanner(System.in);
	String kind;
	String name;
	String flavor;
	int numOf;
	int price;
	
	public void input() {
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		kind = sc.nextLine();

		System.out.print("이름 : ");
		name = sc.nextLine();

		System.out.print("맛 : ");
		flavor = sc.nextLine();

		System.out.print("개수 : ");
		numOf = Integer.parseInt(sc.nextLine());

		System.out.print("가격 : ");
		price = Integer.parseInt(sc.nextLine());

	}
	
	public void result() {
		SnackController controller = new SnackController();
		System.out.println(controller.saveData(kind, name, flavor, numOf, price));
		System.out.println(controller.confirmDate());
	}
}
