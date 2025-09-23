<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--  core라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
		function update(f) {
			
			f.action ="member_update.do"
			f.submit();
			
		}
		
	</script>

</head>
<body>
	
	<form>
		
		<input type="hidden" value="${vo.idx}" name="ori_idx">
	
		<table border="1">
			<caption>회원 정보 수정</caption>
			
			<tr>
				<th>이름</th>
				<td><input name="name" value="${vo.name}"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input name="id" value="${vo.id}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" value="${vo.pwd}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" value="${vo.email}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" value="${vo.addr}"></td>
			</tr>
			
			
			<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="update(this.form)">
			</td>
			</tr>
	
		</table>
	
	</form>
</body>
</html>