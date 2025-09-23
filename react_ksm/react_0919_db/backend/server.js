const express = require("express");
const mysql = require("mysql2");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

// DB 연결 정보
const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "qwer1234",
  database: "signup",
});

// DB 접속 및 쿼리 요청
app.post("/signup", (req, res) => {
  // DB sql insert문 작성
  const sql = "insert into login (`name`,`email`,`password`) values (?)";

  const values = [req.body.name, req.body.email, req.body.password];

  db.query(sql, [values], (err, data) => {
    if (err) {
      return res.json("Error");
    }
    return res.json(data);
  });
});

// 로그인 요청
app.post("/login", (req, res) => {
  // DB sql select문 작성
  const sql = "select * from login where `email` =? and `password` =?";

  const values = [req.body.email, req.body.password];

  db.query(sql, values, (err, data) => {
    if (err) {
      return res.json("error");
    }

    if (data.length > 0) {
      return res.json("success");
    } else {
      return res.json("fail");
    }
  });
});

// DB에 연결이 잘 되었을 경우 콘솔창에 listening 나옴 (backend 에서 npm start)
app.listen(3000, () => {
  console.log("listening");
});
