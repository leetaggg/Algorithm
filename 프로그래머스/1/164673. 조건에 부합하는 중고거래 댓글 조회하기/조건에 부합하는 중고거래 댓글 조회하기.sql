SELECT a.TITLE, a.BOARD_ID, b.REPLY_ID, b.WRITER_ID, b.CONTENTS, DATE_FORMAT(b.CREATED_DATE, '%Y-%m-%d') AS CREATE_DATE
FROM USED_GOODS_BOARD AS a
JOIN USED_GOODS_REPLY AS b ON a.BOARD_ID = b.BOARD_ID
WHERE DATE_FORMAT(a.CREATED_DATE, '%Y-%m') = '2022-10'
ORDER BY b.CREATED_DATE ASC, a.TITLE ASC;