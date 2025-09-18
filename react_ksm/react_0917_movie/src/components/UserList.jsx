import React from "react";
import { Link } from "react-router-dom";

const UserList = ({ users }) => {
  return (
    <div>
      {users.map((user) => {
        return (
          <div className="card mb-2">
            <div className="card-body">
              <Link to={`/users/${user.id}`}>{user.name}</Link>
            </div>
          </div>
        );
      })}
    </div>
  );
};

// 내가 해본 방법
// function UserList({ users }) {
//   return (
//     <div>
//       <table border="1">
//         <thead>
//           <tr>
//             <th>이름</th>
//           </tr>
//         </thead>
//         <tbody>
//           {users.map((u) => (
//             <tr>
//               <td>{u.name}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//   );
// }

export default UserList;
