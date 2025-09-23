<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
		function modify(f) {
			
			f.action ="dept_modify_fin.do"
			f.submit();
			
		}
		
	</script>

</head>
<body>
	<form>
	
		<input type="hidden" value="${vo.deptno}" name="ori_deptno">
	
		<table border="1">
			<caption>부서 정보 수정</caption>
			
			<tr>
				<th>부서 번호</th>
				<td><input name="deptno" value="${vo.deptno}"></td>
			</tr>
			<tr>
				<th>부서 이름</th>
				<td><input name="dname" value="${vo.dname}"></td>
			</tr>
			<tr>
				<th>부서 위치</th>
				<td><input name="loc" value="${vo.loc}"></td>
			</tr>
			
			<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="modify(this.form)">
			</td>
			</tr>		
		</table>
	
	</form>
</body>
</html>