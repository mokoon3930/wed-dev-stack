import React from "react";
// 회원가입 입력 values -> props로 name, email, password 받음
function LoginValidation(props) {
  if (props.name == "") {
    alert("이름을 입력하세요");
    return;
  }

  if (props.email == "") {
    alert("이메일을 입력하세요");
    return;
  }

  if (props.password == "") {
    alert("비밀 번호를 입력하세요");
    return;
  }
}

export default LoginValidation;
