package com.kh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {   // 권한 제한 (모든 설정들 시작)

	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		
		return http
				.csrf(csrf-> csrf.disable())    // 웹 보안 토큰 설정 (비활성화)
				.authorizeHttpRequests(authorize -> 
					authorize									
						.requestMatchers("/mypage").authenticated()   // .authenticated() 로그인된 사용자(아니면 막음 403 error)
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()
						// authorize.anyRequest().permitAll() 어떤 요청인든 전부 수락을 할게 시큐리티 설정 전처럼 다 들어가짐
				)  
				.formLogin(form -> 
						form.loginPage("/login")        // 내가 만든 로그인 페이지로 처리를 하겠다
							.defaultSuccessUrl("/") // 로그인 후 내가 가고 싶은 페이지
				)
				.logout(logout -> 
					logout.logoutUrl("/logout")
						.logoutSuccessUrl("/")  // 로그 아웃 후 가고 싶은 페이지
				)
				.build();                      
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
