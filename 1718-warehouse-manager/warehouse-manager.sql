# Write your MySQL query statement below


with volume_cte as (
    select product_id,
        Width*Length*Height as vol
    from Products
)
select w.name as warehouse_name,
    sum(v.vol*w.units) as volume
from Warehouse w join
volume_cte v on v.product_id = w.product_id
group by w.name