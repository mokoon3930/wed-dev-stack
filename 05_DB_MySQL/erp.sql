CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

SELECT * FROM member;

CREATE TABLE bank(
	name VARCHAR(100),
    balance INT
);
INSERT INTO bank VALUES('지은', 100000);
INSERT INTO bank VALUES('지연', 0);

SELECT * FROM bank;


Drop Table bank;

UPDATE bank SET balance = balance - 30000, name = '1' WHERE name = '지은';
UPDATE bank SET balance = balance + 30000 WHERE name = '지연';

CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    addr VARCHAR(200)
);

SELECT * FROM person;

SELECT id FROM person;

SELECT * FROM person WHERE name = '강성모' AND age = 20 AND addr = '오산시';




CREATE TABLE book(
	book_no INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
	author VARCHAR(50) NOT NULL,
    access_age INT DEFAULT 0
);

CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,	
	pwd VARCHAR(200) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE rent(
	rent_no INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(100),
    book_no INT,
    rent_Date Date DEFAULT (CURRENT_DATE)
);

ALTER TABLE Rent ADD 
FOREIGN KEY (id) REFERENCES Member (id);

ALTER TABLE Rent ADD
FOREIGN KEY (book_no) REFERENCES Book (book_no);

drop table client_info;

DELETE FROM member;
SELECT * FROM member;

SELECT * FROM rent JOIN book USING(book_no) WHERE id = 'test01';










