# Write your MySQL query statement below

-- select a.row_num as id, student from ((SELECT 
--     student, 
--     CASE WHEN ROW_NUMBER() OVER (ORDER BY id) % 2 = 0 THEN 
--         ROW_NUMBER() OVER (ORDER BY id) - 1
--     END AS row_num
-- FROM Seat)
-- union
-- (SELECT 
--     student, 
--     CASE WHEN ROW_NUMBER() OVER (ORDER BY id) % 2 != 0 THEN 
--         (case when lead(id,1) over (ORDER BY id) != null then ROW_NUMBER() OVER (ORDER BY id) + 1 else ROW_NUMBER() OVER (ORDER BY id) end)
--     END AS row_num
-- FROM Seat))a
-- where a.row_num is not null
-- order by a.row_num

select case WHEN ROW_NUMBER() OVER (ORDER BY id) % 2 = 0 THEN 
        ROW_NUMBER() OVER (ORDER BY id) - 1 when ROW_NUMBER() OVER (ORDER BY id) = (Select count(*) from Seat) then ROW_NUMBER() OVER (ORDER BY id) else ROW_NUMBER() OVER (ORDER BY id) + 1 end as id,student
from Seat order by id