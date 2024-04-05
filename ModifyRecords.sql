-- Change the name of the student with ssn = 746897816 to Scott
UPDATE students
SET name = 'Scott'
WHERE ssn = 746897816;

-- Change the major of the student with ssn = 746897816 to Computer Science, Master
UPDATE major m
JOIN students s ON m.snum=s.snum
SET m.name='Computer Science', m.level='MS'
WHERE s.ssn=746897816;

-- Delete all registration records that were in “Spring2021”
-- take off safe mode
SET SQL_SAFE_UPDATES = 0;

DELETE FROM register
WHERE regtime='Spring2021'; 
-- turn safe mode back on
SET SQL_SAFE_UPDATES = 1;
