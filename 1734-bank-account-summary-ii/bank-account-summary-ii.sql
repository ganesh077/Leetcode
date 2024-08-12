# Write your MySQL query statement below

SELECT u.name,
    sum(t.amount) as balance 
FROM  Transactions t JOIN
Users u on t.account = u.account
GROUP BY t.account
HAVING sum(t.amount) > 10000