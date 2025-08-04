package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kh.security.controller.PageController;
import com.kh.security.mapper.UserMapper;
import com.kh.security.vo.User;

@Service
public class UserService {
   
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder bcpe;

	
	public void register(User vo) {
		//System.out.println("암호화처리 : " + vo.getPwd());
		//System.out.println("암호화처리후 : " + bcpe.encode(vo.getPwd()));
		vo.setPwd(bcpe.encode(vo.getPwd()));                  // 다시 vo에 암호화된 값을 넣기
		if(vo.getId().equals("admin")) {
			vo.setRole("ROLE_ADMIN");
		}else {
			vo.setRole("ROLE_USER");
		}
		mapper.register(vo);
	}


	public User login(User vo) {                 // vo 암호화 되지 않은 정보 user 암호화된 정보
		User user = mapper.login(vo.getId());
		
		if(user!=null && bcpe.matches(vo.getPwd(), user.getPwd())) {
			System.out.println("로그인 성공");
			return user;
		}
		
		return null;
	}	
}














