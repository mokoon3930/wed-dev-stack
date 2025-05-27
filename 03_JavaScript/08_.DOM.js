// 태그로 가지고오기 : 같은 태그로 여러개일수 있으므로 배열로 변환
function btn1() {
  console.log(document.bady);
  const h1 = document.getElementsByTagName("h1");
  console.log(h1);
  // 모든 div 태그들 가져오기
  const divs = document.getElementsByTagName("div");
  console.log(divs);
  console.log(divs[0]); // 첫번쨰 div
}
//id로 가져오기 : 고유한 id로 하나의 태그만 선택가능
function btn2() {
  const testId = document.getElementById("testId");
  console.log(testId);
  const testId2 = document.getElementById("testId2");
  console.log(testId2);
}
//Class로 가지고오기: 같은 클래스명이 여러개일 수 있으므오 배열로 변환
function btn3() {
  const div = document.getElementsByClassName("testClass");
  console.log(div);
  console.log(div[1]);
}
//name으로 가져오기 : 같은 name속성이 여러게일 수 있으므로 배열로 변환
function btn4() {
  const div = document.getElementsByName("testName");
  console.log(div);
}
//CSS 선택자 문법이 가능
function btn5() {
  // 한 개만 가지고 오고 싶으면 querySelector
  const div = document.querySelector("#testId");
  console.log(div);
  // 여러게를 가지고 오고 싶다면 querySelectorAll
  const divs = document.querySelectorAll("div");
  console.log(divs);
}
function btn6() {
  const divs = document.querySelectorAll(".testClass");
  divs[0].textContent = "<span>안녕하세요</span>"; // 태그를 문자로 출력
  divs[1].innerHTML = "<span>안녕하세요</span>"; // 태그를 HTML로 출력
  console.log(divs[1].innerHTML);
}
function btn7() {
  const div = document.querySelector("#testId");
  // 속성 추가
  //div.setAttribute("속성명", "속성 값")
  div.setAttribute("date-test", "테스트");

  //속성 값 가져오기
  console.log(div.getAttribute("date-test"));
  console.log(div.getAttribute("class"));
  //속성 삭제
  div.removAttribut("id");
}
function btn8() {
  const div = document.querySelector("#testId");
  div.style.color = "orange";
  div.style.backgroundColor = "yellow";
}
// classList 조작 : add, remove, contains, toggle
const div2 = document.querySelector("#testId2"); // 전체 영역에서 선택
function btn9() {
  div2.classList.add("black"); // black 크래스 추가
}
function btn10() {
  div2.classList.remove("black"); // black 클래스 제거
}
function btn11() {
  const has = div2.classList.contains("black"); // black 클래스가 있는지 확인
  console.log("black크래스 있는지 : ", has);
  // black 클래스가 있다면 제거, 없다면 추가
  if (has) div2.classList.remove("black");
  else div2.classList.add("black");
}
function btn12() {
  div2.classList.toggle("black");
}
function btn13() {
  const div = document.querySelector("#testId3");
  const p = document.createElement("p"); // p 태그 새성
  p.textContent = "텍스트 추가"; // p 태그 안에 텍스트 내용 추가
  div.appendChild(p); // div에 p 추가
}
function btn14() {
  const testId3 = document.querySelector("testId3");
  const p = document.querySelector("#testId3 p");
  //testId3.removeChild(p); // 부모를 통해 삭제
  //console.log(p);
  if (p) p.remove(); // 최신 브라운저만 지원
}
