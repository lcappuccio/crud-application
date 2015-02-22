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
* RandomEmployee: **d**isplays a random employee
* ListEmployees: **d**isplays a table with all employees in the database
* EmployeesJson: **d**isplays the full employee list in a JSON
* InsertEmployee: **c**reate an employee
