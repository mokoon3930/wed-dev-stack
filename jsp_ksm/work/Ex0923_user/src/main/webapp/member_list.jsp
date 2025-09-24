<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--  core라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="js/httpRequest.js">
	
</script>


<script>
	function del( idx ) {
		
		if( !confirm("정말로 삭제를 하실 건가여?" )){
			return;
		}
		//location.href="member_del.do?idx="+idx;
		let url = "member_del.do";
		let param ="idx="+ encodeURIComponent(idx); // 특수문자 param 을 보넬떼 깨질경우 인코딩
		sendRequest(url, param, resDel, "post");
	}
	
	function resDel(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let data = xhr.responseText;
			
			let json = eval(data);
			if(json[0].res == 'yes'){
				alert('삭제 성공');
				location.href='list.do';
			}else{
				alert('삭제 실패');
			}
		}
		
	}
	
</script>

</head>
<body>
	<table border="1">
		<caption>::회원 목록 조회::</caption>
			<tr>
				<th>회원번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>비고</th>
			</tr>
		
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.name}</td>
				<td>${vo.id}</td>
				<td>${vo.pwd}</td>
				<td>${vo.email}</td>
				<td>${vo.addr}</td>
				<td>
					<input type="button" value="수정" onclick="location.href='member_one.do?idx=${vo.idx}'">
					<input type="button" value="삭제" onclick="del(${vo.idx})">
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="7">
				<input type="button" value="등록" onclick="location.href='regi_form.jsp'">
			</td>
		</tr>
		
	</table>
</body>
</html>