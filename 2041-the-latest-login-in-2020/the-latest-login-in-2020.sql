# Write your MySQL query statement below
with year_cte as (
SELECT user_id,
    time_stamp,
    extract(year from time_stamp) AS years
FROM Logins
)
SELECT user_id,
    max(time_stamp) as last_stamp
FROM year_cte
WHERE years = '2020'
GROUP BY user_id