import React from "react";

function Todo({ list, listDel }) {
  return (
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
  );
}

export default Todo;
