<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

	function insert(f){
		f.action = "visit_insert.do";
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
	        <div>
	            내용:<input name="content" style="width: 100%;"/>
	        </div>
	        <div>
	            작성자:<input name="name" style="width: 100%;" />
	            작성자ip:<input name="ip" style="width: 100%;"> 
	        </div>
	        
	        <div>
	            비밀번호:<input name="pwd" type="password" style="width: 60%;" />
	            <input type="button" value="등록" onclick="insert(this.form)"/>
	            <input type="button" value="취소" onclick="history.back()" />
	        </div>
    	</div>
	</form>
</body>
</html>