<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- c:if 사용했을 경우 
		1이 들어오면 "안녕하세요~" 출력
		2가 들어오면 "처음 뵙겠습니다!" 출력
		그 외에는 "모르는 사람인제요.." 출력
		eq == 같음 , ne != 같음, && and 사용가능
	--%>
	<c:if test="${param.number eq '1'}">
		<h2>안녕하세요~</h2>
	</c:if>
	<c:if test="${param.number == '2'}">
		<h2>처음 뵙겠습니다!</h2>
	</c:if>
	<c:if test="${param.number ne '1' and param.number ne '3'}">
		<h2>모르는 사람인데요..</h2>
	</c:if>
	<%--
		== : eq, != : ne, < : lt, > : gt, <= : le, >= :ge, && : and, || : or, ! : out
		== null : empty - null이거나 빈 문자열인경운 true
		!=null : not empty
	 --%>
	<%-- c:choose 사용 --%>
	<c:choose>
		<c:when test="${param.number eq '1'}">
			<h2>안녕하세요~</h2>
		</c:when>
		<c:when test="${param.number eq '2'}">
			<h2>처음 뵜겠습니다!</h2>
		</c:when>
		<c:otherwise>
			<h2>모르는 사람인데요..</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>















