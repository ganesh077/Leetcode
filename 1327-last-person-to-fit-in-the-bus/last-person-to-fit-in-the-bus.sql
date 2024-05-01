# Write your MySQL query statement below

select b.person_name from Queue a join Queue b
on a.turn <= b.turn group by b.turn having sum(a.weight) <= 1000
order by sum(a.weight) desc limit 1


