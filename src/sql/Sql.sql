-- 1. 组合两个表
-- https://leetcode-cn.com/problems/combine-two-tables/
select a.FirstName, a.LastName, b.City, b.State from Address b right join Person a on a.PersonId = b.PersonId;

-- 2. 第二高的薪水
-- https://leetcode-cn.com/problems/second-highest-salary/
-- 首先使用 IFNULL() 函数, 优先返回第一个参数, 第一个参数为空, 则返回第二个.
-- 对于相同 Salary 的数据, 需去重
select IFNULL((select distinct Salary as SecondHighestSalary from Employee order by Salary desc limit 1,1), null) as SecondHighestSalary;