import logo from "./logo.svg";

import { useState } from "react";

function App() {
  let [num, setNum] = useState(0);

  function down() {
    setNum(num - 1);
  } // 함수를 따로 빼 줄수 있음

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
      <input type="text" onChange={changeNum} />

      <samp>{num}</samp>
    </div>
  );
}

export default App;
