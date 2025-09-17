import { useState } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  let [users, setUsers] = useState([]);
  let [inputName, setInputName] = useState("");
  let [inputAge, setInputAge] = useState("");

  let addUser = () => {
    if (inputName.trim() && inputAge.trim()) {
      setUsers([...users, { inputName, inputAge }]);
      setInputName("");
      setInputAge("");
    }
  };

  let userDel = (index) => {
    // filter는 배열을 순회하면서 조건에 맞는 요소를 골라서 새로운 배열을 만드는 함수
    // filter함수는 최대 두 개의 인자를 가지는데,
    // 첫번째 인자 res는 배열의 i번째 요소( 사용을 하지 않으면 _로 지정 )
    // 두번째 인자 i는 배열의 index
    let newUser = users.filter((res, i) => i !== index);
    setUsers(newUser);
  };

  return (
    <div className="App">
      <h1>사용자 목록</h1>
      <input
        type="text"
        value={inputName}
        onChange={(e) => {
          setInputName(e.target.value);
        }}
        placeholder="이름을 입력하세요"
      ></input>
      <br />
      <input
        type="text"
        value={inputAge}
        onChange={(e) => {
          setInputAge(e.target.value);
        }}
        placeholder="나이를 입력하세요"
      ></input>
      <br />

      <input type="button" value="확인" onClick={addUser}></input>

      <br />

      <table border="1">
        <tr>
          <th>이름</th>
          <th>나이</th>
          <th>비고</th>
        </tr>
        {users.map((u, index) => (
          <tr>
            <td>{u.inputName}</td>
            <td>{u.inputAge}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={() => {
                  userDel(index);
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
