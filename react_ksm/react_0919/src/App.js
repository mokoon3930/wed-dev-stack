import Header from "./components/Header";
import Celebrity from "./pages/Celebrity";
import Home from "./pages/Home";
import Movies from "./pages/Movies";
import NotFound from "./pages/NotFound";
import Tv from "./pages/Tv";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import "./index.css";
import MovieDetail from "./pages/MovieDetail";

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/movie" element={<Movies />} />

          <Route path="/movie/:title" element={<MovieDetail />} />

          <Route path="/person" element={<Celebrity />} />
          <Route path="/tv" element={<Tv />} />
          <Route path="/*" element={<NotFound />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
