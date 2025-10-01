<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/visit/resources/js/httpRequest.js"></script>

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
	            내용:<input name="content" value="${vo.content}" style="width: 100%;"/>
	        </div>
	        <div>
				<input type="hidden" name="ip" value="${vo.ip}"/>
	            작성자:<input name="name" style="width: 100%;" value="${vo.name}"/>
	            ip:<input name="name" style="width: 100%;" value="${vo.ip}"/>  
	        </div>
	        <div>
	            작성일자:<input name="regdate" value="${vo.regdate}" style="width: 100%;"/>
	        </div>
	        <div>
	            비밀번호:<input name="pwd" type="password" style="width: 60%;" />
	            <input type="button" value="수정" onclick="update(this.form)"/>
	            <input type="button" value="취소" onclick="history.back();"/>
	        </div>
    	</div>
	
   </form>
</body>
</html>