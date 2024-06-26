# Write your MySQL query statement below

with weight_cte as (
select person_name,weight,
    sum(weight) over (order by turn) as weights
from Queue
)
select person_name
from weight_cte
where weights <= 1000
order by weights desc limit 1


    


