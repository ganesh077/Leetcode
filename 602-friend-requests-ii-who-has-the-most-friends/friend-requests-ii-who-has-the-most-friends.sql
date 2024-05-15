-- # Write your MySQL query statement below
select id, num as num from (select id,sum(count) as num from (select requester_id as id,count(requester_id) as count from  RequestAccepted group by id
union all
select accepter_id as id, count(accepter_id) as count  from RequestAccepted group by id)a
group by id)b
order by num desc limit 1

