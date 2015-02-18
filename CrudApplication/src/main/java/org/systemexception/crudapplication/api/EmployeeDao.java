package org.systemexception.crudapplication.api;

import java.util.List;
import org.systemexception.crudapplication.pojo.Employee;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:28:10 AM
 */
public interface EmployeeDao {

	public Employee findById(int empId);

	public List<Employee> getAllEmployees();

	public List<Employee> findByName(String empName);

	public boolean insertEmployee(Employee emp);

	public boolean deleteEmployee(Employee emp);

	public int countEmployees();
}
