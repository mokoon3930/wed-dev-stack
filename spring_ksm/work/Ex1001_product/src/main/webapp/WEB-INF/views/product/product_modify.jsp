<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
	
	function modify(f) {
		f.action = "modify.do"
		f.submit();
	}
	
	</script>

</head>
<body>
	<jsp:include page="../index.jsp"></jsp:include>
	
	<form method="post" enctype="multipart/form-data">
	
	<input type="hidden" value="${vo.idx}" name="idx">
	
	<table border="1" align="center" width="600">
		
		<tr>
			<td>제품 카테고리</td>
			<td>
				<select name="category">
					<option> 카테고리 선택 </option>
					<option value="com001" ${vo.category == 'com001' ? 'selected' : ''}>컴퓨터</option>
					<option value="ele002" ${vo.category == 'ele002' ? 'selected' : ''}>생활가전</option>
					<option value="sp003" ${vo.category == 'sp003' ? 'selected' : ''}>스포츠 용품</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>제품코드</td>
			<td>
				<input name="p_num" value="${vo.p_num}">
			</td>
		</tr>
		
		<tr>
			<td>제품 이름</td>
			<td>
				<input name="p_name" value="${vo.p_name}">
			</td>
		</tr>
		
		<tr>
			<td>제조사</td>
			<td>
				<input name="p_company" value="${vo.p_company}">
			</td>
		</tr>
		
		<tr>
			<td>가격</td>
			<td>
				<input name="p_price" value="${vo.p_price}">
			</td>
		</tr>
		
		<tr>
			<td>할인가격</td>
			<td>
				<input name="p_saleprice" value="${vo.p_saleprice}">
			</td>
		</tr>
		
		<tr>
			<td colspan="2">제품 설명</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<textarea rows="5" cols="80" style="resize:none" name="p_content">${vo.p_content}</textarea>
			</td>
		</tr>

		<tr>
			<td>작은 사진(썸네일)</td>
			<td>
				<input type="file" name="p_image_s" value="${vo.p_image_s}">
			</td> 
		</tr>
		
		<tr>
			<td> 큰 사진(상세보기)</td>
			<td>
				<input type="file" name="p_image_l" value="${vo.p_image_l}">
			</td> 
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" onclick="modify(this.form)">
				<input type="button" value="취소" onclick="history.go(-1)">
			</td>
		</tr>
	
	</table>
	
	</form>
</body>
</html>