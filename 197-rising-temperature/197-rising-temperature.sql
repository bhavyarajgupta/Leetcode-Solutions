# Write your MySQL query statement below
select w1.id from weather as w1,weather as w2
where
datediff(w1.RecordDate, w2.RecordDate) = 1 and w1.Temperature >
w2.Temperature