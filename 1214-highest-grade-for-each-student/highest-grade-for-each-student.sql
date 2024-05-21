select student_id,course_id,grade from (select student_id,course_id,grade,
rank() over (partition by student_id order by grade desc,course_id) as ranker from
Enrollments )a where ranker = 1 group by  student_id order by student_id
