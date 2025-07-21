<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/list.css"></link>
</head>
<body>
	
		<!-- localhost:8080/list
			 스키마 : sakila 
			 테이블 : film_text 
			 데이터들 리스트로 가져와서 여기 페이지에 보여주기!
			 
			 1. 환경 설정 : pom.xml , application.properties 
			 2. VO : Film, mapper : film-mapper.xml -> <select id="showFilm"> <resultMap> 사용 가능
			 3. FilmMapper, FilmService, FilmController
			 4. list.jsp에 리스트 가져오기
			 
		 -->

		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">제목</th>
						<th scope="col">설명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.title}</td>
							<td>${item.desc}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
</body>
</html>
