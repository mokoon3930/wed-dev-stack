<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  core라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	
	
	<table align="center" border="1" width="600">
		<tr bgcolor="#dedede">
			<th>제품코드</th>
			<th>이미지</th>
			<th width="20%">제품명</th>
			<th width="25%">단가</th>
			<th>수량</th>
			<th colspan="2">금액</th>	
		</tr>
		
	<c:forEach var="vo" items="${list}">
	
		<tr align="center">
			<td>${vo.p_num}</td>
			<td>
				<img src="images/${vo.p_image_s}" width="100">
			</td>
			<td>${vo.p_name}</td>
			<td>단가 :<fmt:formatNumber value="${vo.p_price}"/><br>
				<font color="red">
					세일가격 :<b><fmt:formatNumber value="${vo.p_saleprice}"/></b>
				</font>
			</td>
			
			<td>
				<from>
					<input type="hidden">
					<input size="3" value="${vo.c_cnt}"><br>
					<input type="submit" value="수정">
				</from>
				
			</td>
			
			<td>${vo.c_cnt * vo.p_saleprice}</td>
			
			<td>
				<input type="button" value="삭제">
			</td>
			
		</tr>
		
		</c:forEach>
		
		<tr>
			<td colspan="6" align="right">
				총 결제액 &nbsp;
			</td>
			
			<td align="center"><fmt:formatNumber value="${total}"/>
			</td>
		</tr>
	
		
	</table>
	
</body>
</html>