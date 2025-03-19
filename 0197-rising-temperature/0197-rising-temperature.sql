# Write your MySQL query statement below
select id from 
(
    select
        id,
        recordDate,
        temperature,
        lag(recordDate) over (order by recordDate) as prev_date, 
        lag(temperature) over (order by recordDate) as prev_temp
        from Weather
) subquery 
    where temperature > prev_temp and datediff(recordDate, prev_date) = 1;