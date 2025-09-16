import logo from "./logo.svg";

import { useState } from "react";

function App() {
  let [num, setNum] = useState(0);

  let [check, setCheck] = useState("채크 하세요");

  function down() {
    setNum(num - 1);
  } // 함수를 따로 빼 줄수 있음

  function changeNum(event) {
    setNum(Number(event.target.value));
  }

  function checkEvenOdd() {
    if (num == 0) {
      setCheck("0 입니다");
    } else if (num % 2 == 0) {
      setCheck("짝수 입니다");
    } else {
      setCheck("홀수입니다");
    }
  }

  return (
    <div className="App">
      <button onClick={down}>-</button>
      <button
        onClick={(e) => {
          setNum(0);
        }}
      >
        0
      </button>
      <button
        onClick={(e) => {
          setNum(num + 1);
        }}
      >
        +
      </button>

      <input type="text" value={num} onChange={changeNum} />
      <span>{num}</span>

      <br />

      <input
        type="button"
        value="짝수 홀수 확인"
        onClick={checkEvenOdd}
      ></input>

      <br />

      <div>{check}</div>
    </div>
  );
}

export default App;
