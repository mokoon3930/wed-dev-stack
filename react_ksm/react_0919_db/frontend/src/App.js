import Login from "./Login";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import Signup from "./Signup";
import MainComp from "./MainComp";

function App() {
  return (
    // 위에 improt 꼭 시켜주기
    // BrowserRouter > Routes > Route (순서대로 넣어줘야 사용가능)
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/signup" element={<Signup />}></Route>
        <Route path="/main_content" element={<MainComp />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
