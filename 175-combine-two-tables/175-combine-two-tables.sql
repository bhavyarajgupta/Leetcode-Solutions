# Write your MySQL query statement below
Select  firstName,lastName,city,state from Person as p left Join Address as a on p.PersonId = a.PersonId;