<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="/login" method="post">
	아이디 : <input type="text" name="username"></br>
	비밀번호 : <input type="text" name="password"></br>
	<button type="submit">로그인</button>
	</form>
</body>
</html>