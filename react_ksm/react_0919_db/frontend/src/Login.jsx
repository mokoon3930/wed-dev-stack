import React, { useState } from "react";
// <Link   to= />를 사용을 해서 패이지 이동
import { Link } from "react-router-dom";
import LoginValidation from "./LoginValidation";
import axios from "axios";

function Login() {
  const [values, setValues] = useState({ email: "", password: "" });

  const [errors, setErrors] = useState();

  const handleSubmit = (e) => {
    e.preventDefault();
    setErrors(LoginValidation(values));
    // axios를 사용을 해서 서버 요청
    axios.post("http://localhost:3000/login", values).then((res) => {
      if (res.data == "success") {
        window.location.href = "/main_content";
      } else {
        alert("아이디나 비밀 번호가 일치 하지 않습니다");
      }
    });
  };

  const handleInput = (e) => {
    // 원래 들어가 있는 값을 조회를 하고 입력받는 값을 확인
    setValues({ ...values, [e.target.name]: [e.target.value] });
  };

  return (
    <div className="d-flex justify-content-center align-items-center bg-primary vh-100">
      <div className="bg-white p-3 rounded w-25">
        <form action="" onSubmit={handleSubmit}>
          <div className="mb-3">
            <label>Email</label>
            <input
              placeholder="enter email"
              onChange={handleInput}
              name="email"
            />
          </div>

          <div className="mb-3">
            <label>Password</label>
            <input
              type="password"
              placeholder="enter password"
              onChange={handleInput}
              name="password"
            />
          </div>

          <button type="submit" className="btn btn-success">
            로그인
          </button>

          <p>계정이 없으신가요??</p>
          <Link className="btn btn-default border" to="/Signup">
            회원 가입
          </Link>
        </form>
      </div>
    </div>
  );
}

export default Login;
