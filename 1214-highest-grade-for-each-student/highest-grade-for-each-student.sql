WITH MaxGrades AS (
    SELECT student_id, MAX(grade) AS max_grade
    FROM Enrollments
    GROUP BY student_id
),
FilteredEnrollments AS (
    SELECT e.student_id, e.course_id, e.grade
    FROM Enrollments e
    JOIN MaxGrades mg ON e.student_id = mg.student_id AND e.grade = mg.max_grade
)
SELECT student_id,
       CASE WHEN COUNT(*) = 1 THEN MAX(course_id) ELSE MIN(course_id) END AS course_id,
       MAX(grade) AS grade
FROM FilteredEnrollments
GROUP BY student_id
ORDER BY student_id;


