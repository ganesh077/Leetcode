# Write your MySQL query statement below

select employee_id, department_id from (
select employee_id,(case when count(*) > 1 then 
(SELECT department_id 
         FROM Employee e2
         WHERE e2.employee_id = e1.employee_id AND e2.primary_flag = 'Y') else department_id end) as department_id
from Employee e1 group by employee_id) a where department_id is not null