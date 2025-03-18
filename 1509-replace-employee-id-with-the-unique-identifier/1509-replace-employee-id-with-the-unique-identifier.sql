# Write your MySQL query statement below
SELECT e.name, COALESCE(eu.unique_id, NULL) AS unique_id
FROM Employees e
LEFT JOIN EmployeeUNI eu ON e.id = eu.id;