# Write your MySQL query statement below

SELECT
w.name,
w.population,
w.area
FROM World as w
WHERE area >= 3000000 OR population >=25000000
