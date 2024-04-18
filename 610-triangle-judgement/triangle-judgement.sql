# Write your MySQL query statement below

select x,y,z,case when (x+y+z) - (greatest(x,y,z)*2) > 0 then "Yes" else "No" end as triangle from  Triangle
