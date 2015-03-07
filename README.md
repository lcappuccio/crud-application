# CrudApplication 
A basic crud application example

## Installation
1. Create the necessary database table on your favourite RDBMS (see script.sql)
2. Download and change JDBC URL, username and password in org.systemexception.crudapplication.impl.EmployeeDaoImpl
3. Compile and deploy to you favourite web container

## Usage
Available servlets:
* BadWorld: just generates a bunch of random hex codes
* HelloWorld: pretty explicative
* InsertEmployee: **c**reate an employee
* RandomEmployee: **r**eads a random employee
* ListEmployees: **r**eads a table with all employees in the database
* EmployeesJson: **r**eads the full employee list in a JSON
* DeleteEmployee: **d**elete an employee