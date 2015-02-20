package org.systemexception.crudapplication.api;

import java.util.List;
import org.systemexception.crudapplication.pojo.Employee;

/**
 *
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
	public Employee findById(int empId);

	/**
	 * Returns an employee full list
	 *
	 * @return
	 */
	public List<Employee> getAllEmployees();

	/**
	 * Find employee by name
	 *
	 * @param empName
	 * @return
	 */
	public List<Employee> findByName(String empName);

	/**
	 * Insert employee, no ID
	 *
	 * @param emp
	 * @return
	 */
	public boolean insertEmployee(Employee emp);

	/**
	 * Deletes employee
	 *
	 * @param emp
	 * @return
	 */
	public boolean deleteEmployee(Employee emp);

	/**
	 * Returns the employee count
	 *
	 * @return
	 */
	public int countEmployees();
}
