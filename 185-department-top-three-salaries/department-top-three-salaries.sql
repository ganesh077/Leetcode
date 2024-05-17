# Write your MySQL query statement below

select name as Department,emp as Employee,salary as Salary from 
(select  b.name as name,a.name as emp,salary,dense_rank() over (partition by b.name order by a.salary desc) as ranker from Employee a join Department b on a.departmentId = b.id)c
where c.ranker <=3


