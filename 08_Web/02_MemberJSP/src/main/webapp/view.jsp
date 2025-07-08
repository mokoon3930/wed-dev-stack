<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- SearchServelet 생성 , search.jsp 에서 결과 확인 --%>
	<h2>회원 조회</h2>
	<form action= "search">
	검색할 회원아이디 : <input type="text" name="id"><br>
	<input type="submit" value="조회">
	</form>

	<h1>전체 리스트</h1>
	<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); %>
	
	<table border="1">
	<tr>
	<th>아이디</th>
	<th>비밀번호</th>
	<th>이름</th>
	<th>나이</th>
	</tr>
	
	
	<%for(Member member : list){ %>
	<tr>
	<li><%=member.getId()%></li>
	<li><%=member.getPwd()%></li>
	<li><%=member.getName()%></li>
	<li><%=member.getAge()%></li>
	</tr>
		
		<% }%>
		</table>
	
</body>
</html>