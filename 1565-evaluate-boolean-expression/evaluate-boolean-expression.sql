-- Write your PostgreSQL query statement below
select e.left_operand,
    e.operator,
    e.right_operand,
    (case when e.operator = '=' and v.value = k.value then 'true'
    when e.operator = '>' and v.value > k.value then 'true'
    when e.operator = '<' and v.value < k.value then 'true'
    else 'false' end) as value 
from Expressions e
left join Variables v on e.left_operand = v.name
left join Variables k on e.right_operand = k.name

