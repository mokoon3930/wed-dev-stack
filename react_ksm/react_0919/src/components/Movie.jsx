import React from "react";
import { useNavigate } from "react-router-dom";

const ING_BASE_URL = "https://image.tmdb.org/t/p/w1280/";

export default function Movie(props) {
  const navigate = useNavigate(); // 페이지 전환 기술

  const onClickMovieItem = () => {
    navigate(`/movie/${props.title}`, { state: props });
  };
  return (
    <div className="movie-container" onClick={onClickMovieItem}>
      <img src={ING_BASE_URL + props.poster_path} />

      <div className="movie-info">
        <h4>{props.title}</h4>
        <span>{props.vote_average}</span>
      </div>
    </div>
  );
}
