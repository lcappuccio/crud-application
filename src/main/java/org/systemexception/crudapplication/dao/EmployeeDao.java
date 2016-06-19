package org.systemexception.crudapplication.dao;

import org.systemexception.crudapplication.model.Employee;

import java.util.List;

/**
 * @author leo
 * @date Feb 18, 2015 12:28:10 AM
 */
public interface EmployeeDao {

	/**
	 * Find employee by ID
	 *
	 * @param empId
	 * @return
	 */
	Employee findById(int empId);

	/**
	 * Returns an employee full list
	 *
	 * @return
	 */
	List<Employee> getAllEmployees();

	/**
	 * Find employee by name
	 *
	 * @param empName
	 * @return
	 */
	List<Employee> findByName(String empName);

	/**
	 * Insert employee, no ID
	 *
	 * @param emp
	 * @return
	 */
	boolean insertEmployee(Employee emp);

	/**
	 * Insert employee with ID
	 *
	 * @param emp
	 * @return
	 */
	boolean insertEmployeeWithId(Employee emp);

	/**
	 * Update an employee attribute (not id)
	 *
	 * @param emp
	 * @return
	 */
	void updateEmployee(Employee emp);

	/**
	 * Deletes employee
	 *
	 * @param emp
	 * @return
	 */
	boolean deleteEmployee(Employee emp);

	/**
	 * Returns the employee count
	 *
	 * @return
	 */
	int countEmployees();

	/**
	 * Cleans database of tests
	 */
	void cleanTests();
}
