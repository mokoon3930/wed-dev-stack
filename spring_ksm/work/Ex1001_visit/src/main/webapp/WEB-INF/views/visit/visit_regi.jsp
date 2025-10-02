<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

	function insert(f){
		
		// 유효성 체크
		
		f.action = "visit_insert.do";
		f.method = "post";
		f.submit();
	}

</script>

</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>새 글 작성</caption>
			<tr>
				<th>작성자</th>
				<td>
					<input name="name">
				</td>
			</tr>
			
			<tr>
				<th colspan="2">내용</th>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea name="content" rows="5" cols="50" wrap="on" style="resize: none"></textarea>
				</td>
			</tr>
			
			<tr>
				<th>비밀 번호</th>
				<td>
					<input type="password" name="pwd" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="작성" onclick="insert(this.form)">
					<input type="button" value="목록으로" onclick="history.back()">
				</td>
			</tr>
			
		</table>
	
	
	</form>

</body>
</html>