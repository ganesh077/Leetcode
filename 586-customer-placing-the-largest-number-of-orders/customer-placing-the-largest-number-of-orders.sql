# Write your MySQL query statement below

with rank_count_cte as (
    select rank() over (order by count(order_number) desc) as count_rank,
    customer_number
    from  Orders
    group by customer_number
)
select customer_number
from rank_count_cte
where count_rank = 1
