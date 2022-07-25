# Write your MySQL query statement below
Select e.name as employee from Employee as e 
inner join 
Employee as m on e.managerID = m.id  
where e.salary > m.salary; 