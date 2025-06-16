/*
	LIMT
    - ORDER BY 절보다 뒤에 조건을  걸고 싶을 떄
    - 출력되는 행 수를 제한하는 MySQL 전용 비표준 구문
    - 데이터 양을 제한하고자 할 떄 유용 (페피징 처리)
*/
SELECT *
FROM ACTOR
ORDER BY FIRST_NAME
-- LIMIT 10 OFSET 20;
LIMIT 0, 10;

/*
	CONCAT(커렄, 컬럼, ...)
    - 문자열 하나로 함친 후 결과 반환 (검색 기능 - LIKE랑 %)
*/
SELECT CONCAT(title, description, special_fratures) FROM film;

/*
    날짜 처리 함수
    NOW(), CURRENT_TIMESTAMP () : 현재 날짜와 시간
    CURDATE(), CURRENT_DATE() : 현재 날짜 반환
    CURTIME(), CURRENT_TIME() : 현재 시간 반환
*/
SELECT NOW(), CURRENT_TIMESTAMP(), CURDATE(), CURRENT_DATE(), CURTIME(), CURRENT_TIME();

/*
    YEAR(날짜), MONTH(날짜), DAY(날짜), HOUR(날짜), MINUTE(날짜), SECOND(날짜)
*/
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW()), HOUR(NOW()), MINUTE(NOW()), SECOND(NOW());

/*
    포멧 함수
    FORMAT (숫자, 위치) : 숫자에 3단위씩 콤마에 추가해서 반환
    DATE_FORMAT (날짜, 포멧형식) : 날짜 형식을 변경해서 반환
*/
SELECT 
    FORMAT(amount, 0),
    DATE_FORMAT(payment_date, '%Y년 %m월 %d일 %H시 %i분 %s초'),
    DATE_FORMAT(last_update, '%Y.%m.%d.%T')
FROM payment;

/*
    null 처리 함수
    IFNULL | COALESCE(값, 값이 NULL일 경우 반환값)
*/
SELECT address, address2, IFNULL(address2, '주소없음')
FROM address;

/*
    IF(값, 값2, 값3) | IF(조건, 조건이ture인 경우, 조건 false인 경우)
    - 값1이 null이 아니면 값2 반환, null 값 3 반환
    - 조건에 해당하면 두번쨰 값 반환, 해당하지 않으면 마지막 값 반환
*/
SELECT 
    address2, IF(address2, '주소있음', '주소없음')
    address, IF(address LIKE '1%', ' 해당 값 Ture', 'False')
FROM address;

