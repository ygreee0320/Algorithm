-- 코드를 작성해주세요
SELECT SCORE, g.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM HR_EMPLOYEES emp JOIN (
    SELECT EMP_NO, SUM(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
) g ON emp.EMP_NO = g.EMP_NO
ORDER BY SCORE DESC
LIMIT 1