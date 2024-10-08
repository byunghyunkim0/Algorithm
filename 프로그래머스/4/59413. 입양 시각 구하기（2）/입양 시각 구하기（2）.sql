-- 코드를 입력하세요

WITH RECURSIVE A AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 FROM A
    WHERE HOUR < 23
)

SELECT A.HOUR AS 'HOUR', COUNT(ANIMAL_ID) AS 'COUNT'
FROM A
LEFT OUTER JOIN ANIMAL_OUTS B
ON A.HOUR = HOUR(B.DATETIME)
GROUP BY A.HOUR
ORDER BY A.HOUR;