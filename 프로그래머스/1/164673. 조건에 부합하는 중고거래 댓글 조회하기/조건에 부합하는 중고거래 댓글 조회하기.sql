-- 코드를 입력하세요
SELECT BO.TITLE, BO.BOARD_ID, RE.REPLY_ID, RE.WRITER_ID, RE.CONTENTS, DATE_FORMAT(RE.CREATED_DATE, '%Y-%m-%d') AS 'CREATED_DATE'
FROM USED_GOODS_BOARD AS BO, USED_GOODS_REPLY AS RE
WHERE BO.BOARD_ID = RE.BOARD_ID
AND BO.CREATED_DATE BETWEEN '2022-10-01' AND '2022-10-31'
ORDER BY RE.CREATED_DATE, BO.TITLE;