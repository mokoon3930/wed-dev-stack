/*
	DB 모델링 
    1. 개념적 모델링
		- 엔티티(테이블) 추출
        - 엔티티 간의 관계설정
    2. 논리적 모델링
		- 속성(커럼) 추출
        - 정규화 (1, 2, 3) ----> 이 이상으로 가면 역 정규화
    3. 물리적 모델링
		- 테이블 실직적으로 작성(CREATE문 작성)
	
    * 정규화(Nomalization)
    - 불필요한 데이터의 중복을 제거하여 데이터 모델을 구조화 하는것
    - 효율적인 자료 저장 및 데이터 무결성을 보장 하고 오류를 최소화 하여 안정성을 보장하기 위해 적용함
    
		제 1 정규화 : 복수의 속성값을 갖는 속성을 분리
        제 2 정규화 : 주 식별자에 종속되지 않는 속성을 분리
        제 3 정규화 : 속성에 종속적인 속성을 제거
*/
/*
	사용자 or 사원 관련 정보 들어가는 테이블 하나 CREATE 문 작성해서 제출!
    -> PRIMARY KEY : AUTO_INCREMENT 추가!
    
    MySQL
    - 데이터 타입
    1. 문자
		- CHAR/ **VARCHAR** : 고정 및 가변길이 문자, 반드시 크기지정
        - TEXT : 매우긴 문자열을 저장 하는데 사용
	2. 숫자
		- **INT** : 정수값 저장하는데 사용
        - FLOAT/ DOUBLE : 부동 소수점 저장 하는데 사용
        - DECIMAL : 고정 소수점 저장하는데 사용
	3. 날짜 및 시간
		- **DATE** : 날짜 저장 하는데 사용
        - TIME : 시간 저장 하는데 사용
        - **DATETIME** / TIMESTAMP : 날짜와 시간을 함께 저장
	4. 불리언
		- BOOLEAN / BOOL : 참(TURE) 또는 거짓 (FALSE) 값을 저장하는데 사용
	5. 이진 자료형
		- BLOB : 이진 데이터를 저장하는데 사용, 이미지나 동영상과 같은 이진 파일
        --> 실제로는 이미지나 동영상을 따로 관리(URL만 문자형으로 저장)
*/
DROP TABLE USER;
CREATE TABLE USER(
USER_NO INT PRIMARY KEY,
USER_NAME VARCHAR(20),
GENDER CHAR(3),
USER_ADDR VARCHAR(50),
PHONE VARCHAR(20),
EMAIL VARCHAR(20),
USER_DATE DATE
);
INSERT INTO USER VALUES(1, '강성모', '남', '경기도 오산', '010-5505-3930', 'rkdtjdah98@gmail.com', '25/06/09');
SELECT * FROM USER;




























