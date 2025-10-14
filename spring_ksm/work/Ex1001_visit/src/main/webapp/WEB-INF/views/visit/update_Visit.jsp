<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script >
	 function update(f){
			
			f.action = "visit_update.do";
			f.method = "post";
			f.submit();
		}
		
	</script>
</head>
<body>
	
	<form>
		<input type="hidden" name="idx" value="${vo.idx}">
		
		<table border="1" align="center">
			<caption>수정 페이지</caption>
			<tr>
				<th>작성자</th>
				<td>
					<input name="name" value="${vo.name}"> 
				</td>
			</tr>
			
			<tr>
				<th colspan="2">내용</th>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea name="content" rows="5" cols="50" wrap="on" style="resize: none">${vo.content}</textarea>
				</td>
			</tr>
			
			<tr>
				<th>비밀 번호</th>
				<td>
					<input type="password" name="pwd" value="${vo.pwd}"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="update(this.form)">
					<input type="button" value="목록으로" onclick="history.back()">
				</td>
			</tr>
			
		</table>
	
	</form>

</body>
</html>