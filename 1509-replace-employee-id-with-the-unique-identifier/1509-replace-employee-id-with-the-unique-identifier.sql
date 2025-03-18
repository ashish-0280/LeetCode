# Write your MySQL query statement below
select e.name as name, eu.unique_id as unique_id from Employees e left join EmployeeUNI eu on e.id = eu.id;