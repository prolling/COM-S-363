-- the student number and ssn of the student whose name is 'Becky'
SELECT ssn, snum FROM students WHERE name='Becky';

-- the major name and level of the student whose ssn is 123097834
SELECT m.name, m.level 
FROM major m, students s 
WHERE s.ssn=123097834 and s.snum=m.snum; 

-- The names of all courses offered by the department of Computer Science
SELECT c.name
FROM departments d, courses c
WHERE d.name = 'Computer Science' and d.code=c.department_code; 

-- All degree names and levels offered by the department Computer Science
SELECT d.name, d.level
FROM departments p, degrees d
WHERE p.name='Computer Science' and d.department_code=p.code;

-- The names of all students who have a minor
SELECT s.name
FROM students s, minor m
WHERE s.snum=m.snum;

-- The count of students who have a minor
SELECT COUNT(s.name) 
FROM students s, minor m
WHERE s.snum=m.snum;

-- The names and snums of all students enrolled in course “Algorithm”
SELECT s.name, s.snum
FROM students s, courses c, register r
WHERE c.name='Algorithm' and s.snum=r.snum and r.course_number=c.number;

-- The name and snum of the oldest student
SELECT s.name, s.snum
FROM students s
ORDER BY dob 
LIMIT 1;

-- The name and snum of the youngest student
SELECT s.name, s.snum
FROM students s
ORDER BY dob DESC
LIMIT 1;

-- The name, snum and SSN of the students whose name contains letter “n” or “N”
SELECT s.name, s.snum, s.ssn
FROM students s
WHERE s.name LIKE '%n%' OR s.name LIKE '%N'; 

-- he name, snum and SSN of the students whose name does not contain letter “n” or “N”
SELECT s.name, s.snum, s.ssn
FROM students s
WHERE s.name NOT LIKE '%n%' AND s.name NOT LIKE '%N';

-- The course number, name and the number of students registered for each course
SELECT c.number, c.name, COUNT(r.snum) as num_reg
FROM courses c, register r, students s
Where c.number=r.course_number AND s.snum=r.snum
GROUP BY c.number;

-- The name of the students enrolled in Fall2020 semester
SELECT s.name
FROM students s, register r
WHERE r.regtime="Fall2020" AND s.snum=r.snum;

-- The course numbers and names of all courses offered by Department of Computer Science
SELECT c.number, c.name
FROM courses c, departments d
WHERE d.name='Computer Science' AND d.code=c.department_code;

-- The course numbers and names of all courses offered by either Department of Computer Science or Department of Landscape Architect
SELECT c.number, c.name
FROM courses c, departments d
WHERE (d.name='Computer Science' OR d.name='Landscape Architect') AND d.code=c.department_code;