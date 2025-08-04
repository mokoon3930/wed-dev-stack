<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script> <!-- 로그인 끝나고 일어나야 함 -->
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="/login" method="post" id="frm">      <!-- frm 으로 id, pwd 한번에 받음 -->
		아이디 : <input type="text" name="id"></br>
		비밀번호 : <input type="text" name="pwd"></br>
		<button type="submit" id="login">로그인</button>     <!-- css는 class 선택 만인하고 / 제이쿼리는 id 선택 많이 함 -->
	</form>
	<script>												
		$("#login").click((e) => {
			e.preventDefault();  // 기존 이벤트 제거                   
				$.ajax({
					// 요청
					type: 'post',
					url: '/login',
					data: $('#frm').serialize(),           // 한번에 받은 serialize
					// 응답
					success: function(data) {
						// alert(data);위에 뜨는 메세지
						// localStorage에 token 키 값으로 저장
						localStorage.setItem('token', data);
						// / <- index.jsp로 이동
						location.href = "/";
					},
					error:function(xhr, status, error){
				
					}
				});
			});
	</script>
</body>
</html>