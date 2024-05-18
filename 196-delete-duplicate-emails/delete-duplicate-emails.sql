# Write your MySQL query statement below

with duplicates as (
    select email,min(id) as id from Person group by email having count(*) > 1
)
delete from Person where email in (select email from duplicates)
and id not in (select id from duplicates)