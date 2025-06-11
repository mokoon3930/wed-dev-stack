/*
    함수 : 컬럼값을 읽어서 가공된 값을 반환

    -단일행 함수 : N개의 값을 받아서 N개의 결과 반환

    -그룹 함수 : N개의 값을 받아서 1개의 값을 반환

    >>단일행 함수와 그룹 함수는 SELECT 절에서 함께 사용 할수 없음!
    >>함수를 사용할수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/
--단일행 함수
/*
    문자 처리 함수

    LENGTH : 문자 수 반환
    - 한글 1글자 -> 1
    - 영문자, 숫자, 특수문자 -> 1

    LENGTHB : 바이트 수 반환
    -한글 1글자 -> 3
    영문자, 숫자, 특수문자 -> 1
*/  
SELECT
    LENGTH('데이터베이스'), LENGTHB('데이터베이스'),
    LENGTH('database'),LENGTHB('database')
    FROM DUAL; --가상 테이블

/*
    INSTR(컬럼, 찾을문자, 시작위치, 몇번째)
    -특정 문자가 몇 번째 위치하는지 반환
    -없으면 0 반환
    -시작위치 : 1 (앞에서부터), -1(뒤에서부터)
*/
SELECT
    INSTR('AABAACAABBAA', 'B', -1, 2), -- 뒤에서 부터 2번째에 있는 B
    INSTR('AABAACAABBAA', 'D')
    FROM DUAL;

    --USER_INFO에서 각 전화번호에(CONTACT)에서 앞에서부터 5가 들어간 위치 조회
    SELECT CONTACT, INSTR(CONTACT, 5)
    FROM USER_INFO;

     --EMPLOYEE에서'S'가 포함되어 있는 이메일중 @ 위치 조회
     SELECT EMAIL, INSTR(EMAIL, '@')
     FROM EMPLOYEE
     WHERE EMAIL LIKE '%s%';

     /*
        LPAD / RPAD(컬럼, 최종적으로 반환할 문자의 길이, 덧붙이고자 하는 문자)
        - 문자열을 조회시 통일감 있게 조회하고자 할 때 사용
     */
     SELECT
        LPAD('HELLO', 10), LPAD('HELLO', 10, 'A'),
        RPAD('HELLO', 10), RPAD('HELLO', 10, 'A')
    FROM DUAL;

/*
    LTRIM / RTRIM(컬럼, 제거하고자 하는 문자들)
    - 문자열에서 특정 문자를 제거한 나머지
*/
SELECT
    LTRIM('   K H    '), --왼쪽 공백 제거
    LTRIM('ACBAACCCKH', 'ABC'), -- 왼쪽에서 ABC 에 해당하는 문자들 제거
    RTRIM('46548518KH54568', '0123456789') --오른쪽에서 해당하는 숫자들 제거
    FROM DUAL;

/*
    TRIM (LEADING|TRAILING|BOTH 제거고자하는 문자들 FROM컬럼)
    -문자열릐 양쪽(앞/뒤)에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/
SELECT 
    TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'), --LTRIM
    TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ'), -- RTRIM
    TRIM(BOTH 'Z' FROM 'ZZZKHZZZ'), --양쪽 모두
    TRIM('      KH      ')
    FROM DUAL;

/*
    SUBSTR (컬럼, 시작 위치, 추출 길이)
    -문자열에서 특정 부분을 잘라서 추출
*/
SELECT 
    SUBSTR('PROGRAMMING', 5, 2), --RA
    SUBSTR('PROGRAMMING', 1, 6), --PROGA
    SUBSTR('PROGRAMMING', -8, 3) --GRA
FROM DUAL; 

--USER_INFO에서 전화번호 (CONTACT)에서 가운데 번호 4 자리만 조회
SELECT CONTACT, SUBSTR(CONTACT, INSTR(CONTACT, '-') + 1, 4), INSTR(CONTACT, '-') + 1
FROM USER_INFO;

--EMPLOEEY에서 이메일 에서 아이디만 (@ 앞에) 조회
SELECT EMAIL, INSTR(EMAIL, '@'), SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1)
FROM EMPLOYEE;
SELECT EMAIL, REPLACE(EMAIL, '@kh.or.kr', '')
FROM EMPLOYEE;

--주민등록 번호(EMP_NO)를 000000-0****** 로 조회
SELECT EMP_NO, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*')
-- SUBSTR(EMP_NO, 1, 8) || '******',
FROM EMPLOYEE;
--남자 사원들만 조회
SELECT 
    EMP_NO,
    INSTR(EMP_NO, '-') + 1, 
    SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1) = 1;

/*
    LOWER : 다 소문자로 변경 
    UPPER : 다 대문자로 변경
*/
SELECT LOWER('Welcome'), UPPER('Welcome')
FROM DUAL;

/*
    CONCAT(문자열, 문자열)
    -문자열 두개를 전달받아 하나로 합친 후 결과 반환 -- CONCAT 3개는 않된다
*/
--가나다라, 1234를 합치기
SELECT CONCAT('가나다라', '1234') FROM DUAL;
SELECT '가나다라' || '1234' FROM DUAL;
--가나다라, ABCD, 1234를 합치기

SELECT '가나다라' || 'ABCD' || '1234' FROM DUAL;

/*
    REPLACE(컬럼, 바꾸고 싶은 문자열, 바꿀 문자열)
    -특정 문자열 변경
*/
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동')
FROM DUAL;

--USER_INFO에서 서울 이신 분들을 모두 경기로 바꾸기
SELECT ADDRESS, REPLACE(ADDRESS, '서울', '경기')
FROM USER_INFO;

--EMPLOYEE에서 사원들의 이메일 kh.or.kr을 gmail.com으로 바꾸기
SELECT EMAIL, REPLACE(EMAIL, 'kh.or.kr', 'gmail.com')
FROM EMPLOYEE;

/*
    숫자 처리 함수

    ABS : 절대값 반환
    MOD(숫자, 숫자) : 두 수를 나눈 나머지 값 반환
    CEIL : 올림
    FLOOR : 내림
*/
SELECT 
    ABS(5.7), ABS(-10), 
    MOD(10, 3), ---1
    CEIL(123.152),
    FLOOR(123.952)
FROM DUAL;

/*
    ROUND(숫자, 위치)
    -반올림한 결과 반환
*/
SELECT
    ROUND(123.456), -- 123 (위치 생략시 0)
    ROUND(123.456, 1), -- 123.5
    ROUND(123.456, -2) -- 100
FROM DUAL;

/*
    TRUNC(숫자, 위치)
    -위치 지정하여 버림 처림
*/
SELECT
    TRUNC(123.952), -- 123
    TRUNC(123.952, 1) --123.9
FROM DUAL;

/*
    날짜 처리 함수

    SYSDATE : 시스템의 날짜를 반환(현재 날짜)
*/
SELECT SYSDATE FROM DUAL;

--날짜 포맷 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS'; --시간 분초 까지
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YY'; --원래 포맷

/*
    MONTHS_BTWEEN(날짜, 날짜)
    - 입력받은 두 날짜 사이의 개월 수 반환
*/
SELECT FLOOR(MONTHS_BETWEEN('20251216', SYSDATE)) FROM DUAL;

--USER_INFO에서 몇개월 생인지 조회 (BIRTHDATE)
SELECT BIRTHDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, BIRTHDATE))
FROM USER_INFO;

/*
    ADD_MONTHS(날짜, 숫자)
    -특정 날짜에 입력받는 숫자만큼 개월 수를 더한 날짜 반환
*/
SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;

--USER_INFO에서 해당 태어난 날짜부터 20년이 지났을 경우
SELECT BIRTHDATE, ADD_MONTHS(BIRTHDATE, 240)
    FROM USER_INFO;

/*
    NEXT_DAY(날짜, 요일(문자/숫자))
    -특정 날짜에서 구하려는 요일의 가장 가까운 날짜 리턴
    -요일 : 1 - 일요일, 2 - 월요일, ... 7 - 토요일
*/
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'MONDAY') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '월요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 1) FROM DUAL;

--언어변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

/*
    LAST_DAY(날짜)
    -해당 월의 마지막 날짜 반환
*/
SELECT
    LAST_DAY(SYSDATE), 
    LAST_DAY('20250815'), 
    LAST_DAY('2025/12/16')
FROM DUAL;

/*
    EXTRACT(YEAR|MONTH|DAY FROM 날짜)
    - 특정 날짜에서 연도, 월, 일 정보를 추출
*/
--USER_INFO에서 BIRTHDATE로 연도 , 월, 일 따로 조회
SELECT BIRTHDATE,
    EXTRACT(YEAR FROM BIRTHDATE) 연도,
    EXTRACT(MONTH FROM BIRTHDATE) 월,
    EXTRACT(DAY FROM BIRTHDATE) 일
FROM USER_INFO;

/*
    형 변환 함수

    TO_CHAR(날짜|숫자, 포맷)
    -날짜 또는 숫자형 데이터를 문자 타입으로 변환
*/
SELECT TO_CHAR(1234, 'L99,999') FROM DUAL; --현재 설정된 화페 단위


ALTER SESSION SET NLS_CURRENCY = '\';

-- EMPLOYEE에서 연봉을 TO_CHAR를 이용해서 조회 (,)
SELECT SALARY, TO_CHAR(SALARY * 12, '999,999,999') 연봉
FROM EMPLOYEE
ORDER BY 연봉; --별칭으로도 정렬 가능

-- 날짜 -> 문자
SELECT 
    TO_CHAR (SYSDATE, 'YYYY'), -- 년 : YYYY, YY, RRRR, RR, YEAR
    TO_CHAR (SYSDATE, 'MM'), -- 월 : MM, MON, MONTH, RM
    TO_CHAR (SYSDATE, 'D'), -- 일 : D - 주(일 - 1, ..), DD - 월, DDD - 년
    TO_CHAR (SYSDATE, 'DY'),  -- 요일 : DY, DAY
    TO_CHAR (SYSDATE, 'PM HH:MI:SS'), --시분초
    TO_CHAR (SYSDATE, 'AM HH24:MI:SS')
FROM DUAL;


--BIRTHDATE를 '2025년 06월 04일 수요일' 포맷으로 조회
SELECT 
    TO_CHAR (BIRTHDATE, 'YYYY') || '년' ||
    TO_CHAR (BIRTHDATE, 'MM') || '월' ||
    TO_CHAR (BIRTHDATE, 'DD') || '일' ||
    TO_CHAR (BIRTHDATE, 'DAY') 
FROM USER_INFO;

SELECT 
    TO_CHAR (BIRTHDATE, 'YYYY"년" MM"월" DD"일" DAY')
FROM USER_INFO;


/*
    TO_DATE(숫자|문자, 포맷)
    -숫자 또는 문자형 데이터를 날짜 타입으로 변환
*/
-- 숫자 -> 날짜
SELECT TO_DATE(20250604) FROM DUAL;
SELECT TO_DATE(20250604164230, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

-- 문자 -> 날짜
SELECT TO_DATE('20250604') FROM DUAL;
SELECT TO_DATE('20250604164230', 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

/*
    TO_NUMBER(문자, 포맷)
    -문자형 데이터를 숫자 타입으로 변환
*/
SELECT '100000' +'550000' FROM DUAL;
SELECT 
    TO_NUMBER('100,000', '999,999') 
    + TO_NUMBER('550,000', '999,999') 
FROM DUAL;

/*
    NULL 처리 함수

    NVL/COALESCE(값1, 값2)
    - 값1이 NULL이 아니면 값1을 반환하고, 값1이 NULL이면 값2 반환
*/
--USER_INFO에서 MBTI가 NULL인경우 'MBTI 모름' 처리
SELECT NVL(MBTI, 'MBTI 모름') 
FROM USER_INFO;

-- COALESCE(값1, 값2, ...)
-- MBTI가 NULL 이 아니면 MBTI, 
-- NULL이면 HOBBY, 이것 또한 NULL이면 '모름'
SELECT COALESCE(MBTI, HOBBY, '모름')
FROM USER_INFO;

/*
    NVL2(값1, 값2, 값3)
    -값1이 NULL이 아니면 값2, NULL이면 값3
*/
--EMPLOEEY에서 부서코드(DEPT_CODE)가 있으면 '부서있음', 없으면 '부서없음'
SELECT 
    DEPT_CODE,
    NVL2(DEPT_CODE, '부서있음', '부서없음')
FROM EMPLOYEE;

/*
    NULLIF(값1, 값2)
    - 두 개의 값이 동일하면 NULL, 동일하지 않으면 값1
*/
SELECT 
    NULLIF('123', '123'), 
    NULLIF('123', '456')
FROM DUAL;

/*
    선택함수 : 여러 가지 경우에 선택할 수 있는 기능을 제공

    DECODE(값, 조건값1, 결과값1, 조건값2, 결과값2, ...)
    - 비교하고자 하는 값이 조건값과 일치하는 경우 그에 해당하는 결과값 반환

    CASE WHEN 조건식 1 THEN 결과값 1
         WHEN 조건식 2 THEN 결과값 2
         ....
         ELSE 결과값 N
    END
*/
--EMPLOEEY에서 주빈번호(EMP_NO)롤 성별(남, 여) 조회
SELECT SUBSTR(EMP_NO, 8, 1),
    DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여')
 FROM EMPLOYEE;

 SELECT 
    EMP_NAME, EMP_NO,
    CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '남'
         WHEN SUBSTR(EMP_NO, 8, 1) = 2 THEN '여'
     END    
 FROM EMPLOYEE;


 -- 직급 코드가 J7인 사원은 급여를 10%인상
 -- 직급 코드가 J6인 사원은 급여를 15%인상
 -- 직급 코드가 J5인 사원은 급여를 20%인상
 -- 그외 직급인 사원은 급여를 5%인상
 -- 정렬 : 직급코드(JOB_CODE) J1부터, 인상된 급여 높은 순서대로
 SELECT JOB_CODE, SALARY,
    DECODE(JOB_CODE, 
            'J7', SALARY * 1.1, 
            'J6', SALARY * 1.15, 
            'J5', SALARY * 1.2, 
                 SALARY * 1.05) "인상된 급여"
 FROM EMPLOYEE
 ORDER BY JOB_CODE, "인상된 급여" DESC;

 SELECT
    CASE WHEN JOB_CODE = 'J7' THEN SALARY * 1.1
         WHEN JOB_CODE = 'J6' THEN SALARY * 1.15
         WHEN JOB_CODE = 'J5' THEN SALARY * 1.2
         ELSE SALARY * 1.05
         END 
    FROM EMPLOYEE;


 --급여가 500만원 초과 1등급
 --급여가 500만원 이하 350만원 초과일경우 2등급
 --급여가 350만원 이하 200만원 초과일경우 3등급
 --그외 경우 4등급
 SELECT EMP_NAME, SALARY,
    CASE WHEN SALARY > 5000000 THEN '1등급'
         WHEN SALARY > 3500000 THEN '2등급'
         WHEN SALARY > 2000000 THEN '3등급'
         ELSE '4등급'
         END "급여 등급표"    
 FROM EMPLOYEE;

 /*
    그룹 함수 -> 결과값 1개!! (단일행 함수랑 사용 못함)
    - 대량의 데이터들로 집계나 통계 같은 작업을 처리해야 하는 경우 
    - 모든 급룹 함수는 NULL값을 자동으로 제외하고 값이 있는 것들만 계산
 */

-- SUM : 해당 컬럼 값들의 총합계
-- USER_INFO에서 나이(AGE) 모두 더한 값
SELECT SUM(AGE)
FROM USER_INFO;

-- EMPLOEEY에서 부서 코드가 D5인 사원들의 총 연봉
SELECT SUM(SALARY * 12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

SELECT SUM(DECODE(DEPT_CODE, 'D5', SALARY * 12, 0))
FROM EMPLOYEE;

SELECT SUM(CASE WHEN DEPT_CODE = 'D5' THEN SALARY * 12
            ELSE 0
            END)
FROM EMPLOYEE;

/*
    AVG
    -해당 컬럼값드의 평균값
    -모든 그룹 함수는 NULL 값을 자동으로 제외하기 떄문에
      NVL 함수랑 사용할 것을 권장
*/
--USER_INFO에서 평균나이
SELECT FLOOR(AVG(CASE WHEN AGE < 100 THEN AGE END))
FROM USER_INFO;

--EMPLOEEY에서 평균 보너스값 (BONUS)
SELECT AVG(NVL(BONUS, 0))
FROM EMPLOYEE;

/*
    MIN : 해당 컬럼 값들 중에 가장 작은 값
    MAX : 해당 컬럼 값등 중에 가장 큰 값
*/
-- EMPLOYEE에서 MIN, MAX 전부 사용해서
-- 사원명(EMP_NAME), 급여(SALARY), 입사일(HIRE_DATE)
SELECT MIN(EMP_NAME), MAX(EMP_NAME),
        MIN(SALARY), MAX(SALARY),
        MIN(HIRE_DATE), MAX(HIRE_DATE)
FROM EMPLOYEE;

/*
    COUNT -> 가장 많이 사용
    - 컬럼 또는 행의 개수를 세서 반환
    - * : 조회 결과에 해당하는 모든 행 개수 반환
    - 컬럼 : 해당 컬럽값이 NULL이 아니 행 개수 반환
    - DISTINCT 컬럼 : 해당 컬럼 중복을 제외한 값 반환
*/
-- USER_INFO 전체 사람 수 조회
SELECT COUNT(*)
FROM USER_INFO;

-- 서울에 사는 사람들 수만 구하기
SELECT COUNT(*)
FROM USER_INFO
WHERE ADDRESS LIKE '서울%';

SELECT COUNT(CASE WHEN ADDRESS LIKE '서울%' THEN 1 END )
FROM USER_INFO;

-- EMPLOEEY 보너스를 받은 사원 수 조회
SELECT COUNT(BONUS)
FROM EMPLOYEE;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 부서가 배치된 사원 수 조회
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE;

-- 현재 사원들이 속해있는 부서 수 조회

SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

/*
    집계 함수
    - 그룹별 산출한 값의 중간 집계를 계산해주는 함수
    - ROLLUP(컬럼1, 컬럼2) : 컬럼1을 가지고 중간 집계를 내는 함수
    - CUBE(컬럼1, 컬럼2) : 컬럼1을 가지고 중간 집계를 내고, 컬럼2를 가지고 준간집계를 또 내는 함수
*/
-- EPLOYEE에서 직급별 급여합
-- ROLLUP
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE); -- 전체 합계까지 추산

-- CUBE
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE); -- 컬럽 하나 일때는 ROLLUP과 차이가 없음

-- 부서코드와 직급 코드가 같은 사원들의 급여 합계
SELECT * FROM DEPARTMENT;

-- ROLLUP : DEPT_CODE 기준으로만 합계
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

-- CUBE : 두 가지 기준 모두 합계
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE);

/*
    GROUPING
    - ROLLUP 이나 CUBE에 의해 산출된 값이 해당 컬럼 집하의 산출물이면 0을 반환, 아니면 1을 반환 하는 함수
*/
-- ROLLUP
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY), GROUPING(DEPT_CODE) , GROUPING(JOB_CODE)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY), GROUPING(DEPT_CODE) , GROUPING(JOB_CODE)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE);

/*
    집합연산자
    - 여러 개의 퀄리문을 하나의 쿼리문으로 만드는 연산자
    - 여러 개의 쿼리문에서 조회하려고 하는 컬럼의 개수와 이름이 같아야 집합 연산자를 사용할 수 있음!

    UNION (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합처서 추출 - 중복된 값은 제거
    UNION ALL (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합처서 추출 - 중복된 값 포함
    INTERSECT(교집합) : 두 쿼리문을 수행한 결과값에 중복된 결과 값만 추출
    MINUS(차집합) : 선행 커리문의 결과값에서 후행 커리문의 결과 값을 뺀 나머지 결과 값만 추출

*/

-- 부서코드가 D5 인 사원들의 사번, 사원명, 부서코드, 급여 조회
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


-- 급여가 300만원 초과인 사원들의 사번, 사원명, 부서코드, 급여 조회
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 1. UNION
-- 부서 코드가 D5 이거나 급여가 300만원 초과인 사원들 조회
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 위 커리문 대신 WHERE 절에서 OR 연산자로 도 처리 가능
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

-- 2. UNION ALL
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 3. INTERSECT
-- 부서코드가 D5 면서 급여 코드가 300만원 초과인 사원들 조회
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 위 커리문 대신 WHERE 절에서 AND 연산자로 도 처리 가능
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

-- 4. MINUS
-- 부서코드가 D5 이면서 급여가 300만원 사람들 제외
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

SELECT DEPT_CODE, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY <= 3000000;

/*
    GROUPING SETS
    - 그룹별로 처리된 여러개의 SELECT 문의 하나로 합친 결과를 원할 때 사용
*/
-- 부서별, 직급별 사원수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
UNION ALL
SELECT JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY GROUPING SETS(DEPT_CODE, JOB_CODE);
