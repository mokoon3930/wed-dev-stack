package com.kh.practice;

import java.time.LocalDate;
import java.util.Scanner;

import com.kh.practice.controller.UserController;
import com.kh.practice.model.Department;
import com.kh.practice.model.DeptType;
import com.kh.practice.model.UserInfo;




public class Application {
	
	Scanner sc = new Scanner(System.in);
	
	// 컨트롤러랑 연결하는 역활
	UserController uc = new UserController();
	
	UserInfo user = new UserInfo(); // 임시적으로 클라이언트 (화면) 단에 저장 해두는 곳 user
									//	메서드 3개를 한번에 처리하기 위해 생성

	public static void main(String[] args) {
				
		Application app = new Application();
		boolean check = true;
		while(check) {
			int select = app.employeeMenu();
			switch(select) {
				case 1:
					app.insertEmp(null);
					break;
				case 2:
					app.updateEmp();
					break;
				case 3:
					app.printEmp();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					check = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요~");
			}
		}
		
		
	}
	// 메인 메뉴를 출력하는 메서드
	public int employeeMenu() {
		System.out.println("1. 직원 정보 추가");
		System.out.println("2. 직원 정보 수정");
		System.out.println("3. 직원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
		
	// 저장할 데이터를 사용자에게 받는 메서드
		
	
	public void insertEmp(UserInfo U) {
		System.out.println();
		
		
		System.out.print("직원 번호 : ");
		int userNo = sc.nextInt();
		sc.nextLine();
		
		System.out.print("직원 아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("직원 비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.print("직원 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("직원 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		// y일 경우만
		char add = sc.nextLine().charAt(0);
		if (add == 'y') {
		
		System.out.print("직원 전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("직원 주소 : ");
		String addr = sc.nextLine();
		
		System.out.print("직원 성별 : ");
		String gender = sc.nextLine();
		
		System.out.print("직원 생일 (예 : 2025-06-23) : "); // LocalDate.parse(문자열) <- 문자열을 날짜로
		LocalDate birthDate = LocalDate.parse(sc.nextLine());
		//System.out.print("부서 명 : "); // 너무 어렵다면 생략!
		//String deptName = sc.nextLine();
		System.out.println("부서 코드 : ");
		int deptNo = Integer.parseInt(sc.nextLine());
		
		//Department department = new Department();
		//department.setDeptName(deptName);
		
		//추가적으로 들어가는에들
		//uc.addUser(phone, addr, gender, birthDate, department);
		uc.addUser(phone, addr, gender, birthDate, deptNo);
		}
		
		
		
		//기본적으로 들어가는 애들
		uc.addUser(userNo, id, password, email, name);
		
		
	   }
	    
	
	
	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		
		System.out.println("수정하려면 로그인이 필요합니다.");
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String password = sc.nextLine();
		
		user = uc.login(id, password);
		
		// 아이디랑 비밀번호가 틀리다면!
		if(user == null) {
			System.out.println("로그인 실패! 정보 수정할 수 없습니다");
			return;
		}
		
		
		
		// 아이디와 비밀번호 성공했을시에만!
		System.out.println("직원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 생일");
		System.out.println("3. 부서");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
			case 1:
				System.out.print("전화 번호 입력 : ");
				String phone = sc.nextLine();
				user.setPhone(phone);
				break;
			case 2:
				System.out.print("생일 입력 (예 : 2025-06-23) : ");
				LocalDate birthDate = LocalDate.parse(sc.nextLine());
				user.setBirthDate(birthDate);
				break;
			case 3:
				System.out.print("부서 입력 : ");
				String deptName = sc.nextLine();
				Department department = new Department();
				department.setDeptName(deptName);
				user.setDepartment(department);
				break;
			case 9:
				break;
		}
		
		uc.updateUser(user);
	}
	
	// 데이터를 출력하는 메서드
	public void printEmp() {
		// 컨트롤러 연결후 uc(연결된 컨트롤러) getUser (컨트롤러 에서 UserInfo로 리턴을 받음) 선생님 2번째 코드에 있음 현재코드 아님
		System.out.println(user);
	}
}