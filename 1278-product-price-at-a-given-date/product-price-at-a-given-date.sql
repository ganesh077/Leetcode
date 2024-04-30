
select product_id,10 as price
from Products group by product_id
having min(change_date) > "2019-08-16"
union all
select product_id,new_price from Products where
(product_id,change_date) in  (SELECT
      product_id,
      MAX(change_date)
    FROM
      Products
    WHERE
      change_date <= '2019-08-16'
    GROUP BY
      product_id)