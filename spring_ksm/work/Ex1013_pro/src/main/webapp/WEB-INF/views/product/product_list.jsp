<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="js/httpRequest.js"></script>




</head> 
<body>
	<jsp:include page="../index.jsp"></jsp:include>
	
	<div align="center" witdh="600">
		<input type="button" value="상품등록" onclick="location.href='product_regi_form.do'">
	</div>
	
	
	<table align="center" width="600px" border="1" style="border-collapse:collapse;">
	
	
	<c:forEach var="p" items="${list}">
		<tr bgcolor="#dedede">
			<th width="12%">제품코드</th>
			<th width="12%">이미지</th>
			<th width="35%">제품명</th>
			
			<th>가격</th>
			<th width="12%">비고</th>
		</tr>
		
		<tr align="center">
			<td>${p.p_num}</td>
			<td><img src="resources/images/${p.p_image_s}" width="100" height="90"></td>
			<td><a href="view.do?idx=${p.idx}">${p.p_name}</a></td>
			<td><del><fmt:formatNumber value="${p.p_price}"/>원</del><br/>
				<fmt:formatNumber value="${p.p_saleprice}"/>원<br/>
				<font color="red">( ${p.sale_rate}% )</font>
			</td>
			
			<td>
				<input type="button" value="수정" onclick="location.href='product_one.do?idx=${p.idx}'">
			</td>
		</tr>
	
	 </c:forEach>

</body>
</html>