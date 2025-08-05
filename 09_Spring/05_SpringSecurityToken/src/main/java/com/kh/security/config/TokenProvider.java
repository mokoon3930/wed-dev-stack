package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.vo.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenProvider {
	
	private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	public String create(User user) {     // 토근 생성 (로그인 하는 시점)
		return Jwts.builder()
				.signWith(secretKey, SignatureAlgorithm.HS512)      // 이걸 쓰겠다  명시적으로 지정 (싸인 느낌)
				.setClaims(Map.of(									// 정보 담기
					"id", user.getId(),
					"name", user.getName(),
					"role", user.getRole()
				))
				.setIssuedAt(new Date())										  // 토큰 발급 시점
				.setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS))) // 토큰 말료 시점
				.compact();
	}
	
	public User validate(String token) {        // User 정보에서 토큰 가져 오기
		Claims claims = Jwts                    // claims 위를 풀어낸것
				.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJwt(token)
				.getBody();
		return User.builder()
				.id((String) claims.get("id"))
				.name((String) claims.get("name"))
				.role((String) claims.get("role"))
				.build();
	}
	
}












