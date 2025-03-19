# Write your MySQL query statement below

with noTransactions as (
    select v.customer_id 
    from Visits v left join Transactions t 
    on v.visit_id = t.visit_id 
    where transaction_id is null
)
select customer_id, count(*) as count_no_trans from noTransactions group by customer_id;