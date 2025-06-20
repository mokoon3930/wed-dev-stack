package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

public class Application {

	public static void main(String[] args) {
		Snack snack = new Snack();
		SnackController controller = new SnackController();
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("스낵류를 입력하세요");
		System.out.println("종류 : " );
		String kind = sc.nextLine();
		System.out.println("이름 : ");
		String Name = sc.nextLine();
		System.out.println("맛 : ");
		String Flavor = sc.nextLine();
		System.out.println("개수 : ");
		int NumOf = sc.nextInt();
		System.out.println("가격 : ");
		int Price = sc.nextInt(); 
		System.out.println(controller.saveData(kind, Name, Flavor, NumOf, Price));
		System.out.println(controller.confirmDate());

	}

}
