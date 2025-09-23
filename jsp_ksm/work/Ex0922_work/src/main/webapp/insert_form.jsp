<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
		function send( f ){
			
			// 유효서 체크
			let deptno = f.deptno.value;
			
			let patt = /^[0-9]*$/;
			
			if( !patt.test( deptno ) || deptno == ''){
				alert("부서 번호는 정수로 입력 하세요")
				return;
			}
			
			f.action = 'dept_register.do';
			f.submit();
			
		}
	</script>

</head>
<body>
	<form>
		<table border="1">
		
			<tr>
				<th>부서번호</th>
				<td><input name="deptno"></td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td><input name="dname"></td>
			</tr>
			<tr>
				<th>위치</th>
				<td><input name="loc"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="button" value="추가" onclick="send(this.form);">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>