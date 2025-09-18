import { useState } from "react";
import Movie from "./components/Movie";
import "./index.css";
import MovieForm from "./components/MovieForm";
import Navbar from "./components/Navbar";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Users from "./pages/Users";
import Home from "./pages/Home";
import Movies from "./pages/Movies";
import routes from "./routes";

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        {/* <Routes>
          <Route path="/movies" element={<Movies />}></Route>

          <Route path="/users" element={<Users />}></Route>
          <Route path="/" element={<Home />} />
        </Routes> */}

        <div>
          {routes.map((rou) => {
            return (
              <Routes>
                <Route path={rou.path} element={<rou.component />}></Route>
              </Routes>
            );
          })}
        </div>
      </div>
    </Router>
  );
}

export default App;
