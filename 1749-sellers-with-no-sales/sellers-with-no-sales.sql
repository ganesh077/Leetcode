# Write your MySQL query statement below

select seller_name  from Seller  where seller_name  not in 
(select s.seller_name  from
Seller s join Orders o on s.seller_id = o.seller_id
where date_format(o.sale_date,'%y') = '20' 
group by s.seller_id)
order by seller_name
