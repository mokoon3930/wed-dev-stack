import React from "react";
import { useState } from "react";
import InputField from "./InputField";

const MovieForm = ({ addMovie }) => {
  const [movieTitle, setMovieTitle] = useState("");
  const [movieYear, setMovieYear] = useState("");

  const [titleError, setTitleError] = useState("");
  const [yearError, setYearError] = useState("");

  const validateForm = () => {
    let validated = true;

    if (!movieTitle) {
      setTitleError("영화 제목을 입력하세요");
      validated = false;
    }

    if (!movieYear) {
      setYearError("개봉 년도를 입력하세요");
      validated = false;
    }

    return validated;
  };

  const onSubmit = (e) => {
    e.preventDefault();

    if (validateForm()) {
      addMovie({
        id: Date.now(), // 시간이 1000분에 1초 단위여서 중복 방지로 쓰는 경우가 많음
        title: movieTitle,
        year: movieYear,
      });

      setTitleError("");
      setYearError("");
    }

    setMovieTitle("");
    setMovieYear("");
  };

  return (
    <form onSubmit={onSubmit}>
      <InputField
        value={movieTitle}
        placeholder={"영화제목을 입력하세요"}
        onChage={(e) => setMovieTitle(e.target.value)}
        errorMessage={titleError}
      />
      <InputField
        type="number"
        value={movieYear}
        placeholder={"날짜를 입려하세요"}
        onChage={(e) => setMovieYear(e.target.value)}
        errorMessage={yearError}
      />
      <input type="submit" value="영화등록" />
    </form>
  );
};

export default MovieForm;

/* 
export default funtion MovieForm(){  }
*/
