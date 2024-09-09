# Write your MySQL query statement below
with filtered as (
    select o.customer_id,
        sum(p.price * o.quantity) as cost,
        DATE_FORMAT(order_date, "%y%m") as dates
        from Orders o join
            Product p on o.product_id = p.product_id
        group by dates,o.customer_id
        having dates between 2006 and 2007 and cost >= 100
)
select f.customer_id,
    c.name
from filtered f join
   Customers c on f.customer_id = c.customer_id 
group by f.customer_id
having count(*) > 1

