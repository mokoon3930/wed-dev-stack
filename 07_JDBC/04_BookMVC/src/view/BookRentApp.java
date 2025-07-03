package view;

import java.util.Scanner;

import controller.Bookcontroller;
import controller.Membercontroller;
import controller.Rentcontroller;
import vo.Member;

public class BookRentApp {
	
	private Scanner sc = new Scanner(System.in);
	
	//로그인 했을 시 사용자 정보 담을 객체!
	private Member dlient = new Member();
	
	private Bookcontroller bc = new Bookcontroller();
	private Membercontroller mc = new Membercontroller();
	private Rentcontroller rc = new Rentcontroller();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}
	
	public void menu() {
		while(true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.println("선택 >");
			switch (Integer.parseInt(sc.nextLine())){
				case 1:
					printBookAll();
					break;
				case 2:
					register();
					break;
				case 3:
					login();
					break;
			}
			
			
		}
		
		// 1. 전체 책 조회 - 로그인 X
		// 2. 회원가입 - 로그인 X
		// 3. 로그인 - 로그인 X

		// 관리자로 로그인 했을 때
		// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
		// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
		// 3. 로그아웃 - 로그인 O
		
		// 일반 회원이 들어왔을 때
		// 1. 회원탈퇴 - 로그인 O (관리자 X)
		// 2. 로그아웃 - 로그인 O
		// 3. 책 대여 - 로그인 O
		// 4. 내가 대여한 책 조회 - 로그인 O
		// 5. 대여 취소 - 로그인 O

	}
	
	
	
	//1. 전체 책 조회
	private void printBookAll() {
	}
	
	

	// 2. 회원가입
	public void register() {
		Member member = new Member();
		System.out.println("아이디 > ");
		member.setId(sc.nextLine());
		System.out.println("이름 > ");
		member.setName(sc.nextLine());
		System.out.println("비밀번호 > ");
		member.setPwd(sc.nextLine());
		System.out.println("나이 > ");
		member.setAge(Integer.parseInt(sc.nextLine()));
		
		mc.register(member);
		
	}
	
	private void login() {
	}

}
























