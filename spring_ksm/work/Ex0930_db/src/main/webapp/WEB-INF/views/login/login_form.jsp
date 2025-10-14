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
	
		function send(f) {
			
			let url = "check_login.do";
			let param = "id="+f.id.value+"&pwd="+encodeURIComponent(f.pwd.value);
			sendRequest (url, param, resultFn, "post");
			
		}
		
		//콜백 메스드
		function resultFn() {
			if(xhr.readyState == 4 && xhr.status == 200 ){
				
				let data = xhr.responseText;
				let json = eval(data); 
				
				if(json[0].res == 'no_id'){
					alert("존재하는 아이디가 아닙니다")
				}else if(json[0].res == 'no_pwd'){
					alert("비밀번호 불일치")
				}else{
					//로그인 성공화면
					location.href="list.do";
				}
			}
		}
	
	</script>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input name="id"/></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password"/></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="button" value="로그인" onclick="send(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>