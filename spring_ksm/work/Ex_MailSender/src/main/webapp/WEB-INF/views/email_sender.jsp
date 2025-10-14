<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>

<link rel="stylesheet" href="/mail/resources/css/MailSender.css">
<script src="/mail/resources/js/httpRequest.js"></script>

<script>
  /* Ajax 요청: 이메일 전송 */
  function mailCheck(f) {
    let userEmail = f.userEmail.value.trim();
    if (userEmail === "") {
      alert("이메일을 입력하세요.");
      return;
    }
    let url = "mailCheck.do";
    let param = "email=" + encodeURIComponent(userEmail);
    sendRequest(url, param, resultMail, "post");
  }

  let res; 

  /* 컨트롤러에서 받은 인증 코드 처리 */
  function resultMail() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      res = xhr.responseText.trim();
      alert("인증코드가 이메일로 전송되었습니다.");
      document.getElementById("check_input").disabled = false;
    }
  }

  /* 인증 코드 비교 */
  function change_input() {
    const check_input = document.getElementById("check_input").value.trim();
    const mail_check_warn = document.getElementById("mail_check_warn");

    if (check_input === res) {
      mail_check_warn.innerHTML = "✅ 인증 성공!";
      mail_check_warn.style.color = "#28a745";
    } else {
      mail_check_warn.innerHTML = "❌ 인증번호 불일치";
      mail_check_warn.style.color = "#dc3545";
    }
  }
</script>

</head>
<body>
  <form>
    <div id="main_box">
      <h2 style="margin-bottom: 25px;">이메일 인증</h2>

      <!-- 이메일 입력 -->
      <input type="email" name="userEmail" placeholder="이메일 주소를 입력하세요" />

      <!-- 인증 메일 보내기 버튼 -->
      <input type="button" value="본인인증" onclick="mailCheck(this.form)" />

      <!-- 인증번호 입력 -->
      <input type="text" id="check_input" placeholder="인증번호 6자리" maxlength="6" disabled />

      <!-- 인증번호 확인 버튼 -->
      <input type="button" value="인증번호 확인" onclick="change_input()" />

      <!-- 결과 메시지 -->
      <div id="mail_check_warn"></div>
    </div>
  </form>
</body>
</html>
