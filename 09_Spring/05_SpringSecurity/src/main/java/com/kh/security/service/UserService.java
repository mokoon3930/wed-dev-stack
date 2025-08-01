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
public class UserService implements UserDetailsService{

	
    private final PageController pageController;

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder bcpe;

    UserService(PageController pageController) {
        this.pageController = pageController;
    }  // 비밀 번호 땜에 필요함
	

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


	public User login(String id) {
		return mapper.login(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = mapper.login(username);
		System.out.println(user);
		return user;
	}

}
