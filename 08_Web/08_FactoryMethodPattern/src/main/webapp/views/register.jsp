<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 회원가입 로직 : 아이디, 비밀번호, 이름, 나이, 입력 받아서 
						호출 : /register, 방식 : post 
						RegisterSevlet index.jsp로 이동 --%>
						
<%-- 입역 받기 <form> 
	action - 어디로 보넬것인가?
	method - 보네는 방식  
	--%>

	<h1>회원 가입</h1>
	<form action="/register.do" method="post">
		<label>아이디 : <input type="text" name="id"></label><br> 
		<label>비밀번호: <input type="password" name="pwd"></label><br> 
		<label>이름 : <input type="text" name="name"></label><br>
		<label>나이 : <input type="number" name="age"></label><br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>