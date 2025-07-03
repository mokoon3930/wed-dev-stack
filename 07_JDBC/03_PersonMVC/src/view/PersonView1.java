package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.PersonController1;
import vo.Person;

public class PersonView1 {
	PersonController1 pc = new PersonController1();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonView1 view = new PersonView1();
		view.menu();
		
	}
	
	public void menu() {
		while (true) {
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 아이디 조회");
			System.out.println("4. 정보 수정");
			System.out.println("5. 정보 삭제");
			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1:
				System.out.println(addPerson());
				break;
			case 2:
				searchAllPerson();
				break;
			case 3:
				searchPerson();
				break;
			case 4:
				System.out.println(updatePerson());
				break;
			case 5:
				System.out.println(removePerson());
				break;
			}
			
		}
	}

	

	

	

	public String addPerson() {
	
			System.out.print("이름 > ");
			String name = sc.nextLine();
			System.out.print("나이 > ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("주소 > ");
			String addr = sc.nextLine();
			return pc.addPerson(name, age, addr);
		
			return "숫자를 입력해주세요~~";
	}
	
	public void searchAllPerson() {
		
			List<Person> list = pc.searchAllPerson();
			for(Person p : list) {
				System.out.println(p);
			}
		
	}
	
	private void searchPerson() {
		
		
			searchAllPerson();
			System.out.println("아이디 선택 > ");
			int id = Integer.parseInt(sc.nextLine());
			Person person = pc.searchPerson(id);
			if(person != null) System.out.println(person + "이 조회되었습니다!");
			else System.out.println("아이디가 없습니다..");
	
			
		
	}
	private String updatePerson() {
		
			searchAllPerson();
			
			System.out.println("아이디 선택 > ");
			int id = Integer.parseInt(sc.nextLine());
			Person person = pc.searchPerson(id);
			//아이디가 없는 경우는 내보내기!
			if(person == null) return "조회된 아이디가 없습니다";
			
			//아이디가 있는경우만 수정할수 있도록
			System.out.println("이름 수정 > ");
			String name = sc.nextLine();
			
			System.out.println("나이 수정 > ");
			int age = Integer.parseInt(sc.nextLine());
			
			System.out.println("주소 수정 > ");
			String addr = sc.nextLine();
			
			return pc.updatePerson(name, age, addr, id);
		
			return "수정 실패 했습니다";
		
	
	}
	private String removePerson() {
		searchAllPerson();
		
		
		
			System.out.println("아이디 선택 > ");
			int id = Integer.parseInt(sc.nextLine());
			
			Person person;
			person = pc.searchPerson(id);
			
			if(person == null) return "조회된 아이디가 없습니다";
			
			return pc.removePerson(id);
			return "아이디가" + id + "인 회원이 삭제되었습니다";
		
			
		
		return "문제가 심각하니 관리자에게 문의해주세요";
		
	}

}



