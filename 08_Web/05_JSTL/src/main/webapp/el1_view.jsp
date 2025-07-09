<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. 기존 방식</h2>
	<p>request : <%=request.getAttribute("re") %></p>
	<p>session : <%=session.getAttribute("se") %></p>
	<%--
		EL
		- Attribute 에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
		- 바잉딘한 ${값}이 사용한다.
	 --%>
	 <h2>2. EL</h2>
	 <p>request : ${requestScope.re} / ${re}</p>
	 <p>session : ${sessionScope.se} / ${se}</p>
</body>
</html>