import { useState } from "react";
import Todo from "react";

function App() {
  const [list, setList] = useState([]);
  const [work, setWork] = useState("");
  const [date, setDate] = useState("");

  let addList = () => {
    if (work.trim() && date.trim()) {
      setList([...list, { work, date }]);
      setWork("");
      setDate("");
    }
  };

  let listDel = (index) => {
    let newList = list.filter((_, i) => i !== index);
    setList(newList);
  };

  return (
    <div className="App">
      <h1>할일 목록</h1>

      <input
        type="text"
        value={work}
        placeholder="할 일을 입력하세요"
        onChange={(e) => {
          setWork(e.target.value);
        }}
      ></input>

      <br />

      <input
        type="text"
        placeholder="마감일 (예: 2025-09-20)"
        value={date}
        onChange={(e) => {
          setDate(e.target.value);
        }}
      ></input>

      <input type="button" value="추가" onClick={addList} />

      <hr />

      <table border="1">
        <tr>
          <th>할일</th>
          <th>마감일</th>
          <th>작업</th>
        </tr>
        {list.map((u, index) => (
          <tr>
            <td>{u.work}</td>
            <td>{u.date}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={() => {
                  listDel(index);
                }}
              />
            </td>
          </tr>
        ))}
      </table>
    </div>
  );
}

export default App;
