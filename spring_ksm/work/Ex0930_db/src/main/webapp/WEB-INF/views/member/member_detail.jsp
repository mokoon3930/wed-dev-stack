<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- js/httpRequest.js 이경로 X -->
	<script src="/member/resources/js/httpRequest.js"></script>
	
	<script>
	
	
	
	
		function update(f){
			
			if(f.pwd.value.trim() == ''){
				alert("비밀번호는 필수에요");
				return;
			}
			
			f.action = "member_update.do"
			f.method = "post"
			f.submit();
		}
	
	</script>
 
</head>
<body>
	<form>
		
		<input type="hidden" value="${vo.idx}" name="idx">
	
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
				<td><input name="pwd" type="password" value=""></td>
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
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
	
		</table>
	
	</form>
</body>
</html>