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
    <h1>Encoding 처리하기</h1>
    닉네임 : <input type="text" id="nick" />
    <input type="button" id="btn" value="닉네임 보네기" />
    <p id="result"></p>

    <!-- get, /encoding -->
    <!--<script>
		
		let xhr;
		function startRequest(){ // 요청에 해당하는 로직을 담는 메서드
			const nickname = document.querySelector("#nick").value;
			xhr = new XMLHttpRequest();
						xhr.onreadystatechange = callback;
						xhr.open("get", "/encoding?nickname=" + nickname);
						xhr.send(null); // 이때 서버로 전송 .. 실질적인 요청이 들어감
			
		}
		
		function callback(){ // 응답에 해당하는 로직을 담는 메서드
			if(xhr.readyState === 4){
							if(xhr.status === 200){
								//alert(xhr.responseText);
								const nickname = xhr.responseText;
								document.querySelector("#result").innerHTML = nickname;
								
							}
						}
		}
		const btn = document.querySelector("#btn");
		btn.addEventListener("click", startRequest)
	</script> -->
    <!-- jQuery -->
    <script>
      $("#btn").click(() => {
        const nickname = $("#nick").val();
        $.ajax({
          // 요청
          type: "get",
          url: "/encoding",
          data: "nickname=" + nickname,
          // 응답
          success: function (result) {
            $("#result").text(result);
          },
        });
      });
    </script>
  </body>
</html>
