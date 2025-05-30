//코드 중복! 함수로 기능으로
const show = (info) => {
  document.body.innerHTML = `
  <h1>${info}님 환영합니다</h1>
  <div>
  <button type="button" id="logout">로그아웃</button>
  </div>`;
};

//로그인이 되어있는지 안니지 상태확인
const info = localStorage.getItem("name");
if (info) {
  document.body.innerHTML = `
  <h1>${info}님 환영합니다</h1>
  <div>
  <button type="button" id="logout">로그아웃</button>
  </div>`;
}
const logout = document.querySelector("#logout");
logout.addEventListener("click", () => {
  localStorage.removeItem("name");
  location.reload();
});

login.addEventListener("chick", () => {
  //아이디 입력하고 비밀번호 입력받은 값들 로그인 처리
  //로그인 성공하고 이름을 저장
  if (username.value === "" && password.value === "") {
    alert("이름과 비밀번호를 입력해주세요");
    return;
  }
  localStorage.setItem("name", username.value);
  // ~님 환영합니다! 로그아웃 바튼
  document.body.innerHTML = `
  <h1>${username.value}님 환영합니다</h1>
  <div>
  <button type="button" id="logout">로그아웃</button>
  </div>`;
});
