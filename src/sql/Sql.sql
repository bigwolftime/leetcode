-- 1. 组合两个表
-- https://leetcode-cn.com/problems/combine-two-tables/
select a.FirstName, a.LastName, b.City, b.State from Address b right join Person a on a.PersonId = b.PersonId;

-- 2. 第二高的薪水
-- https://leetcode-cn.com/problems/second-highest-salary/
-- 首先使用 IFNULL() 函数, 优先返回第一个参数, 第一个参数为空, 则返回第二个.
-- 对于相同 Salary 的数据, 需去重
select IFNULL((select distinct Salary as SecondHighestSalary from Employee order by Salary desc limit 1,1), null) as SecondHighestSalary;

-- 第 N 高的薪水
-- https://leetcode-cn.com/problems/nth-highest-salary/
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
RETURN (
    # Write your MySQL query statement below.

      select ifnull((select distinct salary from employee order by salary desc limit N,1), null) as salary
    );
END

-- 超过经理收入的员工
-- https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/
select e1.name as Employee from employee as e1 inner join employee e2 on e1.managerId = e2.id and e1.salary > e2.salary

-- 找到重复的电子邮箱
-- https://leetcode-cn.com/problems/duplicate-emails/
select email from person group by email having count(email) > 1

-- 从不订购的客户
-- https://leetcode-cn.com/problems/customers-who-never-order/
select c.Name as Customers from Customers c where c.id not in (select distinct o.CustomerId from Orders o)

