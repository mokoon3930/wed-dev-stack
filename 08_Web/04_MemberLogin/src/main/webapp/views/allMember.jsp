<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 리스트</h1>
	<% List<Member> list = (List<Member>)request.getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
	<% for(Member member : list) { %>
		<tr>
			<td><%=member.getId() %></td>
			<td><%=member.getPwd() %></td>
			<td><%=member.getName() %></td>
			<td><%=member.getAge() %></td>
		<tr>
	<% } %>
	</table>
	<a href="/">메인 페이지로 이동</a>
</body>
</html>