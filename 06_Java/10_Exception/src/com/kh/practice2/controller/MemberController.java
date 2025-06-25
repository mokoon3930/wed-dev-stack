package com.kh.practice2.controller;

import com.kh.practice2.exception.DuplicateIdException;
import com.kh.practice2.exception.RecordNotFoundException;
import com.kh.practice2.model.Member;

public class MemberController {
	
	private Member[] members = new Member[3];
	public int count = 0;
	
	// members- getter
	public Member[] getMembers() {
		return members;
	}
	
	// 추가 로직!
	public void addInfo(Member m) {
		members[count++] = m;
	}

	// 메서드 분리!
	// 아이디 체크! <- 등록 할 때도 필요! 수정할 때도 필요! 여기저기 필요한 경우!
	public int updateCheck(String id) throws RecordNotFoundException{

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].getId().equals(id)) {
				// 기존 배열에서 아이디가 있는 경우!
				return i;
			}
		}

		// 아이디가 없는 경우!
		throw new RecordNotFoundException();
	}

	public void updateInfo(String id, String name, String email, String pwd) throws RecordNotFoundException {
		int index = updateCheck(id);
		members[index].setName(name);
		members[index].setEmail(email);
		members[index].setPwd(pwd);
	}
	
	
	public int idCheck(String id) throws DuplicateIdException {

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].getId().equals(id)) {
				// 기존 배열에서 아이디가 있는 경우!
				throw new DuplicateIdException();
			}
		}

		// 아이디가 없는 경우!
		return -1;
	}

	public void updateInfo1(String id, String name, String email, String pwd) throws RecordNotFoundException{
		int index = updateCheck(id);
		members[index].setName(name);
		members[index].setEmail(email);
		members[index].setPwd(pwd);
	}

	public int update(String id) {
		return 0;
	}
}





















