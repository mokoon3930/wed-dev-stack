import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [greet, setGreet] = useState("");
  let [msg, setMsg] = useState("");

  function nameChange(e) {
    e.preventDefault();

    let name = e.target.myname.value;

    setGreet("안녕하세요" + name + "님, 오늘의 기분은?");
  }

  function moodChange(e) {
    let mood = e.target.value;
    if (mood === "행복") {
      setMsg("행복 하군요");
    } else if (mood === "슬픔") {
      setMsg("ㅠㅠ");
    } else if (mood === "화남") {
      setMsg("화가 나내요");
    } else {
      setMsg();
    }
  }
  return (
    <div className="App">
      <form onSubmit={nameChange}>
        <input
          type="text"
          name="myname"
          placeholder="이름을 입력하세요"
        ></input>

        <input type="submit" value="인사하기"></input>
      </form>

      <p>{greet}</p>

      {/*기분을 선택하는 select 태그*/}
      <div>
        <select onChange={moodChange}>
          <option>기분을 선택 하세요</option>
          <option value="행복">행복</option>
          <option value="슬픔">슬픔</option>
          <option value="화남">화남</option>
        </select>

        <p>{msg}</p>
      </div>

      <br />
    </div>
  );
}

export default App;
