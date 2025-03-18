# Write your MySQL query statement below
select e2.product_name, e1.year, e1.price from Product e2 inner join Sales e1 on e1.product_id = e2.product_id;