SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_OUTS a LEFT JOIN ANIMAL_INS b ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.ANIMAL_ID IS NULL