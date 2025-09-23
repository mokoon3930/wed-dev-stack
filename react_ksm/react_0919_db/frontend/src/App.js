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
        {/*페이지 변로 따로 분리를 해서 코드 양을 줄여줌 (가독성 높임) */}
        <Route path="/" element={<Login />} />
        <Route path="/signup" element={<Signup />}></Route>
        <Route path="/main_content" element={<MainComp />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
