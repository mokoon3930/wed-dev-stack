/*
    서브쿼리(SUBQUERY)
    - 하나의 SQL 문 안에 포함된 또 다른 SQL 문
*/
-- 노옹철 사원의 부서코드
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; -- D9

-- 부서코드가 D9인 사원들 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 노옹철 사원과 같은 부서원들을 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '노옹철');


-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들 조회
SELECT AVG(SALARY)
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEE);

/*
    서브 쿼리의 분류
    - 서브쿼리를 수행한 값이 몇행 몇 열이냐에 따라서 분류
    - 서부쿼리의 종류에 따라 서브 쿼리 앞에서 붙는 연산자가 달라짐

    1. 단일행 서브 쿼리
    - 서브쿼리의 조회한 결과 값의 개수가 오로지 1개일때 (한 행 한 열)
    - 일반 비교연산자 사용가능 : =, !=, >, <, >=, <=
*/
-- 노옹철 사원의 급여보다 더 많이 받는 사원들 조회
SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

SELECT *
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철');

-- 부서별 급여의 합이 가장 큰 부서의 부서코드, 급여의 합 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_CODE);

SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;


-- 전지연 사원이 속해있는 부서원들 조회 (단, 전지연 제외)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '전지연')
                    AND EMP_NAME != '전지연';


/*
    2. 다중행 서브쿼리
    - 서브쿼리 조회 결과 값의 개수가 여러 행 일 때 (여러행 한 열)

    IN 서브쿼리 : 여러개의 결과 값 중에서 한개라도 일치하는 값이 있다면
*/
-- 각 부서별 최고 급여를 받는 사원들
SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT * 
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                    GROUP BY DEPT_CODE);

SELECT *
FROM EMPLOYEE E
WHERE SALARY = (SELECT MAX(SALARY)
                FROM EMPLOYEE
                WHERE DEPT_CODE = E.DEPT_CODE)
    OR SALARY = (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                    WHERE DEPT_CODE IS NULL);

-- 사원에 대한 사번, 이름, 부서 코드, 구분(사수/사원) 조회
-- MANAGER_ID 가 있다면 사수가 있다는 소리 즉, 사원
-- 없다면 사수가 없으니 본인이 사수
SELECT EMP_ID, EMP_NAME, DEPT_CODE, NVL2(MANAGER_ID, '사원', '사수') AS 구분
FROM EMPLOYEE;

SELECT 
    EMP_ID, EMP_NAME, DEPT_CODE,
    CASE WHEN MANAGER_ID IS NULL THEN '사수'
         ELSE '사원'
    END AS 구문
FROM EMPLOYEE;

SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL; -- 누군가의 사수인 분들!

-- 서브쿼리 SELECT 절에서도 사용할 수 있다!
SELECT 
    EMP_ID, EMP_NAME, DEPT_CODE,
    CASE WHEN EMP_ID IN(SELECT DISTINCT MANAGER_ID
                        FROM EMPLOYEE
                        WHERE MANAGER_ID IS NOT NULL)  THEN '사수'
         ELSE '사원'
    END AS 구문
FROM EMPLOYEE;

/*
    비교대상 > ANY (서브쿼리) : 여러개의 결과 값 중에서 "한개라도" 클 경우
                                (= 여러개의 결과 값 중에서 가장 작은 값보다 클 경우)
    비교대상 < ANY (서브쿼리) : 여러개의 결과 값 중에서 "한개라도" 작을 경우
                                (= 여러개의 결과 값 중에서 가장 큰 값보다 작을 경우)
*/
-- 대리 직급임에도 불구하고 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급명, 급여 조회
SELECT MIN(SALARY)
FROM EMPLOYEE
     JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장';

SELECT JOB_NAME, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' AND SALARY > ANY (SELECT SALARY
                                            FROM EMPLOYEE
                                            JOIN JOB USING (JOB_CODE)
                                            WHERE JOB_NAME = '과장');


SELECT JOB_NAME, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' AND SALARY > ANY (SELECT MIN(SALARY)
                                            FROM EMPLOYEE
                                            JOIN JOB USING (JOB_CODE)
                                            WHERE JOB_NAME = '과장');


/*
    비교대상 > ALL (서브쿼리) : 여러개의 "모든" 결과 값들 보다 클 경우
    비교대상 < ALL (서브쿼리) : 여러개의 "모든" 결과 값들 보다 작을 경우
*/
-- 과장 직급임에도 차장 직급인 최대 급여 보다 더 많이 받는 직원들 조회
SELECT SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '차장';

SELECT JOB_NAME, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장' AND SALARY > ALL (SELECT SALARY
                                            FROM EMPLOYEE
                                            JOIN JOB USING (JOB_CODE)
                                            WHERE JOB_NAME = '차장');

SELECT JOB_NAME, EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장' AND SALARY > ALL (SELECT MAX(SALARY)
                                            FROM EMPLOYEE
                                            JOIN JOB USING (JOB_CODE)
                                            WHERE JOB_NAME = '차장');

/*
    3. 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회
SELECT DEPT_CODE, JOB_CODE, EMP_NAME
FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE)
WHERE EMP_NAME ='하이유';

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 
(SELECT DEPT_CODE
 FROM EMPLOYEE
 JOIN JOB USING (JOB_CODE)
 WHERE EMP_NAME ='하이유') 
  AND JOB_CODE = (SELECT JOB_CODE
  FROM EMPLOYEE
  JOIN JOB USING (JOB_CODE)
  WHERE EMP_NAME ='하이유');

-- 하이유 사원의 부서코드, 직급코드
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME ='하이유';

SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = ((SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EMP_NAME ='하이유'));

/*
    4. 다중행 다중열 서브쿼리
    - 서브 쿼리의 조회 결과 값이 여러 행, 여러 열일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                             FROM EMPLOYEE
                             GROUP BY JOB_CODE);

/*
    인라인 뷰
    - FROM 절에 서브쿼리를 제시하고, 서브쿼리를 수행한 결과를 테이블 대신 사용
*/
-- 전 직원중 가장 높은 사위 5명 순위, 이름, 급여
-- ROWNUM : 오라클에서 제공하는 커럼, 조회된 순서대로 1부터 순번 부여
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;
-- SELECT 싷행순서 : FROM > SELECT > ORDER BY

SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT ROWNUM, EMP_NAME, SALARY
        FROM EMPLOYEE
        ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

-- 부서별 평균 급여가 높은 3개 부서의 부서 코드, 평균 급여 조회
-- 참고로 인라인 뷰 안에서 별칭 부여한 게 바깥 쿼리에서 컬럼으로 사용 사능
SELECT DEPT_CODE, ROUND(AVG(NVL(SALARY, 0))) 평균
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY AVG(NVL(SALARY, 0)) DESC;


SELECT ROWNUM, DEPT_CODE, 평균급여
FROM(
    SELECT DEPT_CODE, ROUND(AVG(NVL(SALARY, 0))) 평균급여
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
    ORDER BY AVG(NVL(SALARY, 0)) DESC)
WHERE ROWNUM <= 3;

-- WITH 사용 (TOP N 쿼리)
WITH TOPN_SAL AS (SELECT DEPT_CODE, ROUND(AVG(NVL(SALARY, 0))) 평균급여
                    FROM EMPLOYEE
                    GROUP BY DEPT_CODE
                    ORDER BY AVG(NVL(SALARY, 0)) DESC
                    )
SELECT DEPT_CODE, 평균급여
FROM TOPN_SAL
WHERE ROWNUM <= 3;

/*
    RANK 함수
    - RANK() OVER(정렬기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위 계산
    예) 공동 1위 2명이면 다음 순위는 3위
    - DENSE_RANK() OVER(정렬기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가
    예) 공동 1위가 2명이면 다음 순위는 2위
*/
-- 사원별 급여가 높은 순서대로 조회

SELECT *
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 공동 19위가 2명이라 뒤에 순위가 21위
SELECT 
RANK () OVER(ORDER BY SALARY DESC), 
EMP_NAME, SALARY
FROM EMPLOYEE;

--공동 순위가 2명이라 뒤에순위가 20위
SELECT 
DENSE_RANK() OVER(ORDER BY SALARY DESC), 
EMP_NAME, SALARY
FROM EMPLOYEE;

-- 상위 5명 조회
-- 상위 19위 까지 조회
-- RANK 함수는 WHERE 절에서 사용할수 없다
SELECT *
FROM(
    SELECT
    RANK () OVER(ORDER BY SALARY DESC) RANK,
    EMP_NAME, SALARY
    FROM EMPLOYEE)
WHERE ROWNUM <= 19;

/*
    LAG / LEAD 함수
    - LAG (커럼) OVER (정렬기준) : 이전 행의 값을 현재 기준으로
    - LEAD (커럼) OVER (정렬기준) : 다음행의 값을 현재 기준으로

    --> 행간의 데이터를 비교하거나 변화하는걸 분석하고자 할때
*/
SELECT
    EMP_NAME, SALARY,
    LAG(SALARY) OVER(ORDER BY SALARY DESC),
    LEAD(SALARY) OVER(ORDER BY SALARY DESC)
FROM EMPLOYEE;

-- 이전 사원과의 급여 차이 조회
SELECT
    EMP_NAME, SALARY,
    LAG(SALARY) OVER(ORDER BY SALARY DESC),
    LAG(SALARY) OVER(ORDER BY SALARY DESC) - SALARY
FROM EMPLOYEE;

-- 다음 사원고의 급여차이 조회
SELECT
    EMP_NAME, SALARY,
    LEAD(SALARY) OVER(ORDER BY SALARY DESC),
    LEAD(SALARY) OVER(ORDER BY SALARY DESC) - SALARY
FROM EMPLOYEE;

-- 페이징 처리 (기존 방식)
-- 1페이지
SELECT ROWNUM, E.*
FROM(SELECT * FROM EMPLOYEE) E
WHERE ROWNUM <= 10;

-- 2페이지라면? 11~20
SELECT *
FROM(
    SELECT ROWNUM NUM, E.*
    FROM(SELECT * FROM EMPLOYEE) E
    WHERE ROWNUM <= 10
)
WHERE NUM >= 6;

-- 오라클 이전 버전 X
SELECT * 
FROM EMPLOYEE
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;

-- 1. 국제시장을 감독한 감독의 다른 영화 조회
SELECT TITLE
FROM MOVIE
WHERE DIRECTOR = '윤제균';

-- 2. 서울에 사는 사용자들이 리뷰를 남긴 영화 조회
SELECT * FROM USER_INFO;
SELECT * FROM REVIEW;
SELECT * FROM MOVIE;
SELECT * FROM ACTOR;
SELECT * FROM MOVIE_ACTOR;

SELECT NAME, "COMMENT", TITLE
FROM USER_INFO
    JOIN REVIEW USING (USER_ID)
    JOIN MOVIE USING (MOVIE_ID)
WHERE ADDRESS LIKE '%서울%';

-- 3. 봉준호 감독 영화 중 평균 평점이 3.0이상 영화 조회
SELECT TITLE, "COMMENT", DIRECTOR, RATING
FROM REVIEW
    JOIN MOVIE USING (MOVIE_ID)
WHERE DIRECTOR = '봉준호' AND RATING >= 3;

-- 4. 가장 리뷰 수가 많은 영화 조회
SELECT ROWNUM, COUNT(RATING) "리뷰 수", TITLE
FROM REVIEW
    JOIN MOVIE USING (MOVIE_ID)
GROUP BY TITLE
ORDER BY COUNT (RATING) DESC;

ROWNUM
    


-- 5. 전체 리뷰 평균 평점보다 높은 순으로 3위까지 영화 조회
