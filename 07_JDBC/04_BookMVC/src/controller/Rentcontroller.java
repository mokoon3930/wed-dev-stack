package controller;

import java.util.ArrayList;

import vo.Rent;

public class Rentcontroller {
	
	// 로그인 된 경우만 접근 가능! -> View 에서 조건 걸어서 안보이게 하면 됨!
	
	//7. 책 대여
	public void rentBook(String id, int bookNo) {
		// 한 사람당 대여할수 있는 책은 총 5권
		
		// 중복 책 대여 불가능
		
		// 나이 제한 걸리는 책도 불가능
		
		// 각 책들 마다 가능한 대여가 2권 까지만
	}
	
	//8. 낵 대여한 책 죄회
	public ArrayList<Rent> printRentBook(String id){
		return null;
	}
	
	// 9. 대여 취소
	public void deleteRent(int rentNo) {
		
	}
}
