# Write your MySQL query statement below

select person_name from (select *,sum(weight) over (order by turn) AS cum 
FROM queue)a where a.cum <= 1000 order by a.cum desc limit 1


