package com.kh.practice.controller;

import java.time.LocalDate;

import com.kh.practice.model.Department;
import com.kh.practice.model.DeptType;
import com.kh.practice.model.UserInfo;

public class UserController {
	
	// 배열로 유저 정보 3개 받기
	private UserInfo[] userList = {new UserInfo(), new UserInfo(), new UserInfo()};
	
	private int count = 0; 
	
	// 로그인 -> 유정 정보 클라이언트!
	public UserInfo login(String id, String password) {
		for (UserInfo user : userList) {
			if (id.equals(user.getId()) && password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}
	
	// 오버 로딩
	public void addUser(int userNo, String id, String password, String email, String name) {
	// 접근제어자, 상태(형태)/ void는 리턴 값을 받지를 않는다, 메서드
		userList[count].setUserNo(userNo);
		userList[count].setId(id);
		userList[count].setPassword(password);
		userList[count].setEmail(email);
		userList[count].setName(name);
		count++;
	}
	
	public void addUser(String phone, String addr, String gender, LocalDate birthDate, int deptNo) {
		userList[count].setPhone(phone);
		userList[count].setAddr(addr);
		userList[count].setGender(gender);
		userList[count].setBirthDate(birthDate);
		userList[count].setDeptNo(deptNo);
		
		//지금 테이블리없는 상태여서 지금부터 추가된 코드 너눔 어려우면 X
		// 여기서만 보게 될거임
		Department dept = new Department(deptNo, DeptType.findDeptNo(deptNo));
		userList[count].setDepartment(dept);

		
	}
	// 메서드 1개 
	public void updateUser(UserInfo user) {
		for(UserInfo info : userList) {
			if(user.getUserNo() == info.getUserNo()) {
				info = user;
			}
		}
	}
	
	// 메서드 3개
	/*public void updateUser(String phone) {
		userInfo.setPhone(phone);
	}
	
	public void updateUser (LocalDate birthDate) {
		userInfo.setBirthDate(birthDate);
	}
	
	public void updateUser (Department department) {
		userInfo.setDepartment(department);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
