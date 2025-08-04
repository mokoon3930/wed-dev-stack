<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="/register" method="post">
		아이디 :<input type="text" name="id"></br>
		비밀번호 :<input type="text" name="pwd"></br>
		이름 :<input type="text" name="name"></br>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>