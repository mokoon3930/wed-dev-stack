<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Ajax</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- jQuery 사용하려면 -->
  </head>
  <body>
   <h1>회원가입</h1>
   <form id="frm">
	아이디 : <input type="text" name="id" id="id"><br>
	비밀번호 : <input type="password" name="pwd" id="pwd"><br>
	이름 : <input type="text" name="name" id="name"><br>
	<input type="button" value="회원가입" id="btn">
	</form>
    <script>
	$("#idCheck").click(() => {
		$.ajax({
			// 요청
			type: 'post',
			url: '/signup',
			data: $("#frm").serlize,
			// 응답
			success: function(responce) {
			
			},
			error:function(xhr, status, error){
				
			}
		});
	});

    </script>
  </body>
</html>
