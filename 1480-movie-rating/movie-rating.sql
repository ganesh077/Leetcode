# Write your MySQL query statement below

(select a.name results from Users a join MovieRating b
on a.user_id = b.user_id
group by b.user_id order by count(*) desc,name limit 1)
union all
(select  a.title as results
from Movies a join MovieRating b
on a.movie_id = b.movie_id
where date_format(b.created_at,"%Y-%m") = "2020-02"
group by b.movie_id 
order by avg(rating) desc, a.title limit 1)







