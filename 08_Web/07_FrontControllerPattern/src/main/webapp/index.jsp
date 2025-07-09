<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><%-- '/'는 여기부터 페이지를 검색함 '/'없으면 나중에 페이지가 겹처서 찼을 수가 없음--%>
	<h1>회원 관리</h1>
	<ul>
	<c:choose>
		<c:when test="${member==null}">
		<li><a href="/views/register.jsp">회원가입</a></li> 
		<li><a href="/views/login.jsp">로그인</a></li>
		</c:when>
		<c:otherwise>
		<li><a href="/views/search.jsp">회원검색</a></li>
		<li><a href="/allMember">전체회원검색</a></li>
		<li><a href="/logout">로그아웃</a></li>
		</c:otherwise>
	</c:choose>
	</ul>
</body>
</html>