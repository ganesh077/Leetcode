# Write your MySQL query statement below
select a.customer_id,b.customer_name from (select customer_id,group_concat(product_name order by product_name) as products from Orders group by customer_id)a join Customers b on a.customer_id = b.customer_id
where a.products like '%A%B%' and a.products not like '%C%'