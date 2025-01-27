# Topic3
Learning databases

    /*
	Database 	: MyDbApp
    Author 		: Bruce Wayne
	Date 		: 27th Jan 2025
*/

-- Deleting existing database
drop database if exists mydb;


-- Making a db
create database mydb;

-- Switching to our database
use mydb;

-- Creating a table
-- department table
create table department(
depId int auto_increment primary key,
depName varchar(100) not null,
depLocation varchar(100) not null
);

-- employees table
create table employees(
empId int auto_increment primary key, 		-- unique id for each employee
empName varchar(50) not null,				-- first name (up to 50 chars)
empSurname varchar(50) not null,			-- surname (up to 50 chars)
empEmail varchar(100),						-- email address (up to 100 chars)
empHireDate date,							-- date format for hire date
empSalary decimal(10,2),					-- decimal number, max 10 digits, with 2 decimal places
empDepartment int references department(depId)
);


-- Inserting our employees
insert into employees(empName,empSurname,empEmail,empHireDate,empSalary)
values
("John","Wick","john@gmail.com","2025-01-01",10000),
("Bruce","Wayne","john@gmail.com","2025-01-01",20000),
("Peter","Parker","john@gmail.com","2025-01-01",30000),
("Clark","Kent","john@gmail.com","2025-01-01",40000),
("John","Cena","john@gmail.com","2025-01-01",50000),
("The","Flash","john@gmail.com","2025-01-01",60000);

-- Inserting into departments
select * from department;
insert into department(depName, depLocation)
values
("IT","Tokyo"),
("Marketing","Cape Town"),
("Science","London"),
("Reporting","Sydney"),
("Admin","Fiji");

-- Selecting all employees
select * from employees;

-- Selecting a specific column
select empName, empSurname from employees;

-- Aliases
select empName as `Employee Name`, empSurname as `Employee Surname` from employees;


-- Where clause (used to filter)
-- select rows where salary is more than 20000
select * from employees where empSalary > 20000;
-- find john using id
select * from employees where empId = 5;
-- find john using name
select * from employees where empName = "John";

-- Sorting
-- sorting by one column
select * from employees order by empSalary desc;
-- sorting by multiple columns
select * from employees order by empSalary desc , empHireDate ;

-- Updating data
-- increase salary to 70000 for employees with name John
update employees
set empSalary = 70000
where empName = "John";


-- Deleting data
-- delete all employee named "John Wick"
delete
from employees
where empName = "John" and empSurname = "Wick";


-- Altering tables
select * from employees;

-- Adding a column
-- alter table employees
-- add column department varchar(50) null;

-- Dropping a column
-- alter table employees
-- drop column department;

-- Modifying a column
-- alter table employees
-- modify department varchar(100) null;


-- Join statement
select
e.empName as `Name`,
e.empSurname as `Surname`,
d.depName as `Department`,
d.depLocation as `City`
from
employees e
inner join
department d
on
e.empDepartment = d.depId;
     



 