import Login from "./Login";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import Signup from "./Signup";
import MainComp from "./MainComp";

function App() {
  return (
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
