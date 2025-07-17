package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.mapper.MemberMapper;
import com.kh.ajax.model.vo.Member;

@Service
public class MemberService implements MemberMapper{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member idCheck(String id) {
		return mapper.idCheck(id);
	}

	@Override
	public boolean idBoolCheck(String id) {
		return false;
	}
	

	
	
	
	
}
