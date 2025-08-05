<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
	<sec:authorize access="isAnonymous()"></sec:authorize>
	<sec:authorize access="isAuthenticated()"></sec:authorize>
	<sec:authorize access="hasRole('ADMIN')"></sec:authorize>
	
	<div id="anonymous">
		<a href="/login">로그인</a></br>
		<a href="/register">회원가입</a></br>
	</div>
	
	<div id="authenticated">
		<a href="/logout" id="logout">로그아웃</a></br>
		<a href="/mypage" id="mypage">마이 페이지</a></br>
	</div>
	
	<a href="/admin" id="admin">관리자 페이지</a></br>
	
	
	<script>
		const token = localStorage.getItem("token");
		if(token!==null){
			$('#authenticated').show();
			$('#anonymous').hide();
			$('#admin').hide();
			
			$.ajax({
				url: '/check',
				type: 'get',
				data: {token : token },
				success: function(data){
					if(data.role === 'ROLE_ADMIN'){
						$('#admin').show();
					}
				}
			})
		}else{
			$('#anonymous').show();
			$('#authenticated').hide();
			$('#admin').hide();
		}
		
		$('#logout').click((e) => {
			e.preventDefault();
			localStorage.removeItem("token");
			location.reload();
		})
		
		$('#mypage').click((e) => {
			e.preventDefault();
			$.ajax({
				url:'/mypage',
				type:'get',
				beforeSend: function(xhr){
					xhr.setRequestHeader('Authorization', 'Bearer' + token);
				},
				success: function(data){
					$('body').html(data);
				}
			})
		});
		$('#admin').click((e) => {
					e.preventDefault();
					$.ajax({
						url:'/admin',
						type:'get',
						beforeSend: function(xhr){
							xhr.setRequestHeader('Authorization', 'Bearer' + token);
						},
						success: function(data){
							$('body').html(data);
						}
					})
				});
	</script>
</body>

<!-- SPA  SinglePageApplication -> React, Vue 덮어시우기방식 페이지가 바뀌지 않음-->


</html>










