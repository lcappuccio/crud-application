# CrudApplication 
A basic crud application example

**Master**

[![Build Status](https://travis-ci.org/lcappuccio/crud-application.svg?branch=master)](https://travis-ci.org/lcappuccio/crud-application)
[![codecov.io](https://codecov.io/github/lcappuccio/crud-application/coverage.svg?branch=master)](https://codecov.io/github/lcappuccio/crud-application?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/92b25f0e94fb4704b87af54a39a0d08b)](https://www.codacy.com/app/leo_4/crud-application)

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
* UpdateEmployee: **u**pdate employee record
* DeleteEmployee: **d**elete an employee