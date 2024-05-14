
select visited_on,amount,round((amount/7),2) as average_amount from (SELECT DISTINCT visited_on, 
SUM(amount) OVER(ORDER BY visited_on RANGE BETWEEN INTERVAL 6 DAY   PRECEDING AND CURRENT ROW) amount,
Min(visited_on) over() first
FROM Customer) a
where visited_on >= first+6