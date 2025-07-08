<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리</h1>
	<ul>
		<%-- 로그인 되어 있지 않은 경우 --%>
		<li><a href="register.jsp">회원가입</a></li>
		
		<li><a href="/views/login.jsp">로그인</a></li>
		
		<%-- 로그인 된 경우 --%>
		<li><a href="/views/search.jsp">회원검색</a></li>
		
																								
		<li><a href="/allMember">전체회원검색</a></li>
		<%--전체 회원보기 : AllMemberServlet 
			view.allMember.jsp 에 리스트 출력 --%>
		<li><a href="/logiut">로그아웃</a></li>
		<%-- 로그아웃 하고 index.jsp로! LogiutServlet --%>
	</ul>
</body>
</html>