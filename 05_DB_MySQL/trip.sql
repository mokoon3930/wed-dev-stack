-- 여행사 ERP 시스템 완전한 데이터베이스 스키마

-- 1. 직원 관리 (기본)
CREATE TABLE USER_INFO(
 USER_NO INT PRIMARY KEY AUTO_INCREMENT,
 ID VARCHAR(50) UNIQUE NOT NULL,
 PASSWORD VARCHAR(300) NOT NULL,
 NAME VARCHAR(50) NOT NULL,
 PHONE VARCHAR(50),
 EMAIL VARCHAR(100),
 DEPT_NAME VARCHAR(50), -- 국내팀, 해외팀, 예약팀
 POSITION VARCHAR(50)    -- 사원, 대리, 과장
);

-- 2. 프로젝트 관리 (여행 패키지 개발)
-- 여행 패키지 개발 프로젝트
CREATE TABLE PROJECT (
 PRO_NO INT AUTO_INCREMENT PRIMARY KEY,
 PRO_NAME VARCHAR(100) NOT NULL,     -- "제주도 3박4일 패키지"
 DESTINATION VARCHAR(100),           -- 목적지
 START_DATE DATE,
 END_DATE DATE,
 STATUS VARCHAR(20) CHECK(STATUS IN ('기획중', '판매중', '폐기','완료')),
 MANAGER_NO INT                      -- 담당자
);


-- 여행 상품 정보
CREATE TABLE PACKAGE(
  PACKAGE_NO INT AUTO_INCREMENT PRIMARY KEY,
  PACKAGE_NAME VARCHAR(100) NOT NULL,
  DESTINATION VARCHAR(100),
  DURATION_DAYS INT, -- 여행 일수
  PRICE_ADULT INT, -- 성인 가격
  PRICE_CHILD INT, -- 아동 가격
  PRICE_INFANT INT, -- 유아 가격
  MIN_PARTICIPANTS INT, -- 최소 출발 인원
  MAX_PARTICIPANTS INT, -- 최대 출발 인원
  INCLUDE_FLIGHT BOOLEAN DEFAULT FALSE, -- 항공료 포함 여부
  INCLUDE_HOTEL BOOLEAN DEFAULT FALSE, -- 숙박료 포함 여부
  INCLUDE_MEAL BOOLEAN DEFAULT FALSE, -- 식사 포함 여부
  PACKAGE_DESC TEXT,
  STATUS VARCHAR(20) CHECK(STATUS IN ('판매중', '판매중단', '시즌종료')),
  CREATE_DATE DATETIME DEFAULT (CURRENT_TIMESTAMP),
  PRO_NO INT
);

-- 프로젝트 업무
CREATE TABLE PROJECT_TASKS(
 TASK_NO INT AUTO_INCREMENT PRIMARY KEY,
 PRO_NO INT,
 TASK_NAME VARCHAR(100),             -- "숙박업체 섭외", "일정표 작성"
 STATUS VARCHAR(20) CHECK(STATUS IN ('대기', '진행중', '완료')),
 START_DATE DATE,
 END_DATE DATE,
 ASSIGNED_USER_NO INT                -- 담당자
);

-- 3. 일정 관리
CREATE TABLE SCHEDULE(
 SCHEDULE_NO INT AUTO_INCREMENT PRIMARY KEY,
 TITLE VARCHAR(100) NOT NULL,
 START_DATE DATETIME,
 END_DATE DATETIME,
 LOCATION VARCHAR(100),
 SCHEDULE_TYPE VARCHAR(30),          -- 회의, 고객미팅, 현지답사
 USER_NO INT                         -- 담당자
);
-- 4. 고객관계 관리
-- 고객 정보
CREATE TABLE CUSTOMER(
 CUSTOMER_NO INT AUTO_INCREMENT PRIMARY KEY,
 NAME VARCHAR(100) NOT NULL,
 PHONE VARCHAR(20),
 EMAIL VARCHAR(100),
 VIP_LEVEL VARCHAR(20) DEFAULT '일반', -- 일반, VIP
 MANAGER_NO INT                        -- 담당 직원
);
-- 여행 예약
CREATE TABLE BOOKING(
 BOOKING_NO INT AUTO_INCREMENT PRIMARY KEY,
 CUSTOMER_NO INT,
 /*
 TRAVEL_NAME VARCHAR(100),           -- 여행상품명
 DESTINATION VARCHAR(100),           -- 목적지
 TRAVEL_DATE DATE,                   -- 출발일
 */
 ADULT_COUNT INT,                   -- 성인 인원수
 CHILD_COUNT INT,                   -- 아동 인원수
 INFANT_COUNT INT,                  -- 유아 인원수
 TOTAL_AMOUNT INT,                  -- 총 금액
 
 PAYMENT_STATUS VARCHAR(20) CHECK(PAYMENT_STATUS IN ('대기', '완료')),
 BOOKING_STATUS VARCHAR(20) CHECK(BOOKING_STATUS IN ('예약', '완료', '취소')),
 CREATE_DATE DATETIME DEFAULT (CURRENT_TIMESTAMP)
);


-- 고객 문의
CREATE TABLE CUSTOMER_INQUIRY(membermember
 INQUIRY_NO INT AUTO_INCREMENT PRIMARY KEY,
 CUSTOMER_NO INT,
 TITLE VARCHAR(100),
 CONTENT TEXT,
 STATUS VARCHAR(20) CHECK(STATUS IN ('접수', '처리중', '완료')),
 CREATE_DATE DATETIME DEFAULT (CURRENT_TIMESTAMP),
 ASSIGNED_USER_NO INT                -- 담당 직원
);



-- 5. 외래키 설정
-- 프로젝트 관련
ALTER TABLE PROJECT ADD FOREIGN KEY (MANAGER_NO) REFERENCES USER_INFO(USER_NO);
ALTER TABLE PROJECT_TASKS ADD FOREIGN KEY (PRO_NO) REFERENCES PROJECT(PRO_NO);
ALTER TABLE PROJECT_TASKS ADD FOREIGN KEY (ASSIGNED_USER_NO) REFERENCES USER_INFO(USER_NO);

-- 일정 관련
ALTER TABLE SCHEDULE ADD FOREIGN KEY (USER_NO) REFERENCES USER_INFO(USER_NO);
-- 고객 관련
ALTER TABLE CUSTOMER ADD FOREIGN KEY (MANAGER_NO) REFERENCES USER_INFO(USER_NO);
ALTER TABLE BOOKING ADD FOREIGN KEY (CUSTOMER_NO) REFERENCES CUSTOMER(CUSTOMER_NO);
ALTER TABLE CUSTOMER_INQUIRY ADD FOREIGN KEY (CUSTOMER_NO) REFERENCES CUSTOMER(CUSTOMER_NO);
ALTER TABLE CUSTOMER_INQUIRY ADD FOREIGN KEY (ASSIGNED_USER_NO) REFERENCES USER_INFO(USER_NO);