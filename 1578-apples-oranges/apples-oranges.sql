SELECT 
    a.sale_date, a.sold_num-b.sold_num AS diff
FROM 
    (SELECT sale_date, sold_num FROM Sales WHERE fruit IN ('apples'))a
JOIN
    (SELECT sale_date, sold_num FROM Sales WHERE fruit IN ('oranges'))b
ON 
    a.sale_date = b.sale_date
GROUP BY 1
ORDER BY 1