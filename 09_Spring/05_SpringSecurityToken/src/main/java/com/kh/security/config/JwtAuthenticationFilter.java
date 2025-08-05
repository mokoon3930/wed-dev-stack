package com.kh.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import com.kh.security.vo.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	
	@Autowired
	private TokenProvider tokenProvider;
	
	// Authorization (인증 받을 때 key 값) / Bearer ~~~~(token)
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		// 클라이언트에서 보넨 토큰을 받아서 사용장 확인후 인증 처리 
		String token = parseBearerToken(request);       // Token 만 따오는 것
		System.out.println(token);
		
		if(token != null && !token.equalsIgnoreCase("null")) {
			User user = tokenProvider.validate(token);
			
			// 추출된 인증 정보를 필터링해서 사용할 수 있도록 SecurityContext에 등록
			AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String parseBearerToken(HttpServletRequest request) {        // Token 만 따오는 것
		String bearerToken = request.getHeader("Authorization");		 // 
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {   
			return bearerToken.substring(7);
		}
			
		return null;
	}
}
