<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 로그인 로직 : 아이디, 비밀번호, 이름, 나이, 입력 받아서 호출 : /login, 방식 : post 
													LoginSevlet : 세션 데이더 바인딩! 
													index.jsp로 이동 --%>
	<h1>로그인</h1>
	<form method="post" action="/login.do"> 
		아이디 : <input type="text" name="id"><br> 
		비밀번호: <input type="password" name="pwd"><br> 
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>