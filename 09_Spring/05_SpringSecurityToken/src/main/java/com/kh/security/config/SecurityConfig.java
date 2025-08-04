package com.kh.security.config;

import java.nio.file.attribute.BasicFileAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerJwtAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {   // 권한 제한 (모든 설정들 시작)
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		
		return http
				.csrf(csrf-> csrf.disable())    // 웹 보안 토큰 설정 (비활성화)
				.httpBasic(basic -> basic.disable()) // HTTP Basic 인증 방식 비활성화 -> JWT 토큰 방식 사용
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
				// 세션 설정 -> STATELESS 무상태 방식으로 설정 (서버에서 기역 하지 않게 / 크라이언트가 기역 (토근 방식))
				.authorizeHttpRequests(authorize -> 
					authorize
						.requestMatchers("/mypage").authenticated()   // .authenticated() 로그인된 사용자(아니면 막음 403 error)
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()
						// authorize.anyRequest().permitAll() 어떤 요청인든 전부 수락을 할게 시큐리티 설정 전처럼 다 들어가짐
				) 
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();                      
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
