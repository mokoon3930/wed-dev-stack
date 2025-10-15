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

<script>

	function modify(f) {
		
		let c_cnt = f.c_cnt.value;  
		
		let patt = /^[0-9]*$/;
		if( !patt.test(c_cnt) || c_cnt == '' || c_cnt == 0 ){
			alert("수량은 정수로 입력하세요");
			return;
		}
		
		f.action = "cart_update.do";
		f.submit();
		
	} 
	
function del(c_idx){
		
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		
		location.href="cart_delete.do?c_idx=" +c_idx;
	}

</script>

</head>
<body>
	
	<jsp:include page="../index.jsp"></jsp:include>
	
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
				<img src="resources/images/${vo.p_image_s}" width="100">
			</td>
			<td>${vo.p_name}</td>
			<td>단가 :<fmt:formatNumber value="${vo.p_price}"/><br>
				<font color="red">
					세일가격 :<b><fmt:formatNumber value="${vo.p_saleprice}"/></b>
				</font>
			</td>
			
			<td>
				<form>
					<input type="hidden" name="c_idx" value="${vo.c_idx}">
					<input size="3" value="${vo.c_cnt}" name="c_cnt"><br>
					<input type="button" value="수정"
						onclick="modify(this.form)">
				</form>
				
			</td>
			
			<td>${vo.c_cnt * vo.p_saleprice}</td>
			
			<td>
				<input type="button" value="삭제" onClick="del(${vo.c_idx})">
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