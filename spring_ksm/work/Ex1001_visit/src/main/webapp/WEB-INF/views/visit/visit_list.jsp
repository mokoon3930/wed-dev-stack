<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/visit/resources/css/visit.css">

<script src="/visit/resources/js/httpRequest.js"></script>

<script>

	function del(f){
				 
		 /*
		let url = "del_visit.do";
		let param = "idx="+f.idx.value + "&pwd="+f.pwd.value;
		sendRequest (url, param, deleteFn, "post"); */
		
		let pwd = f.pwd.value;// 원래비번
		let c_pwd = f.c_pwd.value;//입력받은 비번
		
		if(pwd != c_pwd){
			alert("비밀번호 불일치")
			return;
		}
		
		if(!confirm('정말 삭제를 하시겠어요?')){
			return;
		}
		
		let url = "del_visit.do";
		let param = "idx="+f.idx.value;
		sendRequest (url, param, deleteFn, "post");
		
	}
	
	function deleteFn() {
		if(xhr.readyState == 4 && xhr.status == 200 ){
			
			let data = xhr.responseText;
			
			if(data == 'no'){
				alert("삭제 불가능")
				return;
			}else{
				alert("삭제 성공")
				location.href="list.do";
			}
		}
		}
	
	
	function modify(f) {
		
		let pwd = f.pwd.value;// 원래비번
		let c_pwd = f.c_pwd.value;//입력받은 비번
		
		if(pwd != c_pwd){
			alert("비밀번호 불일치")
			return;
		}
		
		f.method ="post"
		f.action="selectOne.do"
		f.submit();
	}

</script>

</head>
<body>
	<div id="main_box">
		<h1>::방명록 리스트::</h1>
		<div align="center">
			<input type="button" value="글쓰기"  onclick="location.href='regi_visit.do'"/>
		</div>
	
	<c:forEach var="vo" items="${list}">
	
	<div class="visit_box">
		<div class="type_content"><pre>${vo.content}</pre></div>
		<div class="type_name">작성자: ${vo.name}(${vo.ip})</div>
		<div class="type_regdate">작성일: ${vo.regdate}</div>
		
		<div>
			<form>
				<input type="hidden" name="idx" value="${vo.idx}">
				<input type="hidden" name="pwd" value="${vo.pwd}">
				
				비밀번호: <input type="password" name="c_pwd">
				<%-- <input type="button" value="수정" onclick="location.href='selectOne.do?idx=${vo.idx}'"/> --%>
				<input type="button" value="수정" onclick="modify(this.form)"/>
				<input type="button" value="삭제" onclick="del(this.form)"/>
			</form>
			
		</div>
		
	</div>
	
	
	</c:forEach>
	
	

</body>

</html>