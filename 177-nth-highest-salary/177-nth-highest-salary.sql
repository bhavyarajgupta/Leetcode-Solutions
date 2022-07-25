CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    declare M INT;
    set M = N - 1;
  RETURN (
      Select ifnull((
        select distinct salary from employee order by salary DESC limit 1 offset M 
      ),null)
      
  );
END