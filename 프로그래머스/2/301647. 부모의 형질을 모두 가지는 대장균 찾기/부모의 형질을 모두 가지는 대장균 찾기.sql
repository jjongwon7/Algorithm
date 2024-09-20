-- 코드를 작성해주세요
SELECT C.ID, C.GENOTYPE, P.GENOTYPE PARENT_GENOTYPE
FROM ECOLI_DATA P INNER JOIN ECOLI_DATA C ON P.ID = C.PARENT_ID
WHERE (P.GENOTYPE & C.GENOTYPE) = IF(P.GENOTYPE > C.GENOTYPE, C.GENOTYPE, P.GENOTYPE)
ORDER BY 1;