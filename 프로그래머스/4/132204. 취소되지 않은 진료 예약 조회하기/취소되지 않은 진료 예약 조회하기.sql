-- 코드를 입력하세요
WITH NOT_CANCLE_TBL AS (SELECT *
                       FROM APPOINTMENT
                       WHERE MCDP_CD = 'CS' AND 
                        APNT_CNCL_YN = 'N' AND
                        YEAR(APNT_YMD) = 2022 AND 
                        MONTH(APNT_YMD) = 4 AND 
                        DAY(APNT_YMD) = 13)
SELECT APNT_NO, PT_NAME, NCT.PT_NO, NCT.MCDP_CD, DR_NAME, APNT_YMD
FROM NOT_CANCLE_TBL NCT 
    INNER JOIN PATIENT P ON NCT.PT_NO = P.PT_NO 
    INNER JOIN DOCTOR D ON NCT.MDDR_ID = D.DR_ID
ORDER BY APNT_YMD;
