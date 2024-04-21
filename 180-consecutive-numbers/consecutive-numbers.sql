# Write your MySQL query statement below

select distinct a.num  as ConsecutiveNums from 
Logs a join Logs b
on b.id = a.id + 1 and a.num = b.num
join Logs c on c.id = a.id+2 and a.num = c.num


