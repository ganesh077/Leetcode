# Write your MySQL query statement below


select l.category,ifnull(accounts_count,0) as accounts_count from (

(SELECT 'Low Salary' as category UNION
     SELECT 'Average Salary' UNION
     SELECT 'High Salary') l
left join
(select a.category, count(*) as accounts_count from (select account_id, income, case when income < 20000 then "Low Salary" when
income between 20000 and 50000 then "Average Salary" else "High Salary" end as category
from Accounts)a group by a.category) r
on l.category = r.category)

