SELECT a.PRODUCT_CODE, SUM(a.PRICE * b.SALES_AMOUNT) AS SALES
FROM PRODUCT AS a
JOIN OFFLINE_SALE AS b
ON a.PRODUCT_ID = b.PRODUCT_ID
GROUP BY a.PRODUCT_CODE
ORDER BY SALES DESC, a.PRODUCT_CODE ASC;




















# SELECT A.PRODUCT_CODE, SUM(A.PRICE * B.SALES_AMOUNT) AS SALES
# FROM PRODUCT A 
# JOIN OFFLINE_SALE B ON A.PRODUCT_ID = B.PRODUCT_ID
# GROUP BY A.PRODUCT_CODE
# ORDER BY SALES DESC, A.PRODUCT_CODE ASC