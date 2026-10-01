SELECT ID,
    CASE
        WHEN rn <= total_cnt / 4 THEN 'CRITICAL'
        WHEN rn <= total_cnt / 2 THEN 'HIGH'
        WHEN rn <= total_cnt * 3 / 4 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (
    SELECT ID,
        ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS rn,
        COUNT(*) OVER() AS total_cnt
    FROM ECOLI_DATA
) AS ranking
ORDER BY ID