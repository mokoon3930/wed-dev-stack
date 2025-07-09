<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 검색</h1>
<form action="/search" method="get">
	검색할 아이디 : <input type="text" name="id"><br>
	<input type="submit" value="검색">
</form>
	<%-- 회원검색  : 아이디 입력 받아서 호출 : /search, 방식 : get 
									SearchSevlet 
									views/result.jsp 에서 성공하면 해당 정보 출력
									실패하면 "검색에 실패" --%>
									
	<h1>회원 정보 검색</h1>
	<%Member member = (Member) request.getAttribute("member"); 
		String id = request.getParameter("id");
	%>
	<%if(member!=null){ %>
	<h1>회원 정보</h1>
	<ul>
		<li>아이디 : <%=member.getId() %></li>
		<li>이름 : <%=member.getName() %></li>
		<li>나이 : <%=member.getAge() %></li>	
	</ul>
	<%}else{ %>
	<h1>아이디가 <%=id %>인 회원정보가 없습니다.</h1>
	<%} %>
	<h1>전체 회원 정보</h1>
</body>
</html>