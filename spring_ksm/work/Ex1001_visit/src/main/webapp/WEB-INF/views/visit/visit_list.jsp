<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/visit/resources/js/httpRequest.js"></script>

<script>

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

</script>

</head>
<body style="text-align: center;">
    <h1>방명록 리스트</h1>
    <input type="button" value="글쓰기"  onclick="location.href='regi_visit.do'"/>
    <c:forEach var="vo" items="${list}">
    
    <form>
    
	    <div style="
	        border: 1px solid #ccc; 
	        padding: 10px; 
	        margin: 10px auto; 
	        width: 60%; 
	        text-align: left; 
	        border-radius: 5px; 
	        box-shadow: 1px 1px 5px #ddd;
	 		">
	 		<input type="hidden" name="idx" value="${vo.idx}" />
	        <div>
	            <input name="content" value="${vo.content}" style="width: 100%;"/>
	        </div>
	        <div>
	        	<input type="hidden" name="ip" value="${vo.ip}" />
	            <input name="name" style="width: 100%;" value="작성자:${vo.name}(${vo.ip})"/> 
	        </div>
	        <div>
	            <input name="regdate" value="작성일자:${vo.regdate}" style="width: 100%;"/>
	        </div>
	        <div>
	            비밀번호:<input name="pwd" type="password" style="width: 60%;" />
	            <input type="button" value="수정" onclick="location.href='selectOne.do?idx=${vo.idx}'"/>
	            <input type="button" value="삭제" onclick="del(this.form)"/>
	        </div>
    	</div>
	
   </form>
   </c:forEach> 
</body>

</html>