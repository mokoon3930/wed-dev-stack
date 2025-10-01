<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--  core라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- js/httpRequest.js 이경로 X -->
	<script src="/member/resources/js/httpRequest.js"></script>

<script>
		 function out(idx) {
			
			if(!confirm('정말 삭제를 하시겠어요?')){
				return;
			}
			
			let url = "del_member.do";
			let param = "idx="+idx;
			sendRequest (url, param, deleteFn, "post");
		} 
		
		
		
		function deleteFn() {
			if(xhr.readyState == 4 && xhr.status == 200 ){
				
				let data = xhr.responseText;
				
				if(data == 'no'){
					alert("삭제 불가능")
				}else{
					alert("삭제 성공")
					location.href="list.do";
				}
			}
			}
		
		function modify(idx){
			location.href ="member_select_form.do?idx="+idx;
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
					<%-- <input type="button" value="수정" onclick="location.href='member_select_form.do?idx=${vo.idx}'"/> --%>
					<input type="button" value="수정" onclick="modify('${vo.idx}')"/>
					<input type="button" value="삭제" onclick="out('${vo.idx}')"/> 				
				</td>
				
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="7">
				<input type="button" value="등록" onclick="location.href='member_regi_form.do'">
			</td>
		</tr>
		
	</table>
</body>
</html>