# Write your MySQL query statement below

select distinct s.name
from SalesPerson s left join
Orders o on o.sales_id = s.sales_id
where s.sales_id not in (
    select o.sales_id from 
    Orders o join
    Company c on c.com_id = o.com_id
    where c.name = 'RED'
)


