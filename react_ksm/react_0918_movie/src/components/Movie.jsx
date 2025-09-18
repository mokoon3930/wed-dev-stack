import React from "react";
// 1번 구조
// const Movie = () => {
//     return(

//     )
// };

// 2번 구조
const ING_BASE_URL = "https://image.tmdb.org/t/p/w1280/";

export default function Movie({ title, poster_path, vote_average }) {
  return (
    <div className="movie-container">
      <img src={ING_BASE_URL + poster_path} />
      <div className="movie-info">
        <h4>{title}</h4>
        <span>{vote_average}</span>
      </div>
    </div>
  );
}
