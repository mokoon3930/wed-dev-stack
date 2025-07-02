package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.PersonController;

public class PersonView {
	
	
	
	public static void main(String[] args) {
		PersonController pc = new PersonController();
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			
			System.out.println("이름 > ");
			String name = sc.nextLine();
			System.out.println("나이 > ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.println("주소 > ");
			String addr = sc.nextLine();
			
			pc.addPerson(name, age, addr);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//pc.searchAllPerson();
		//pc.searchPerson();
		//pc.updatePerson();
		pc.removePerson();
		//테스트 용도
	}

}
