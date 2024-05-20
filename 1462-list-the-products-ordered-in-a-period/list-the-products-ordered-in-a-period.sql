# Write your MySQL query statement below

select p.product_name, sum(o.unit) as unit
from Products p join Orders o 
on p.product_id = o.product_id
where date_format(o.order_date,'%m%y') = '0220'
group by p.product_name
having unit >= 100




