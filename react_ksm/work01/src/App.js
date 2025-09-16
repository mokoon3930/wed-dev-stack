import { useState } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  let [selcolor, setSelColor] = useState("");
  let [mfont, setFont] = useState("");

  let changeBack = (e) => {
    let color = e.target.value;

    // 배경에 따른 글자색 변경
    if (color === "yellow") {
      setFont("black");
    } else {
      setFont("white");
    }
    setSelColor(color);
  };

  return (
    <div className="App">
      <div>
        색상 선택
        <select onChange={changeBack}>
          <option value="">:::색상선택:::</option>
          <option value="red">빨강</option>
          <option value="green">초록</option>
          <option value="black">검정</option>
          <option value="blue">파랑</option>
          <option value="yellow">노랑</option>
        </select>
        <hr />
        <div id="exam_div" style={{ backgroundColor: selcolor, color: mfont }}>
          {selcolor}
        </div>
      </div>
    </div>
  );
}

export default App;
