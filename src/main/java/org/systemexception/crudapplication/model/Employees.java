package org.systemexception.crudapplication.model;

import org.systemexception.crudapplication.dao.EmployeeDao;
import org.systemexception.crudapplication.dao.EmployeeDaoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * @date Feb 18, 2015 12:46:35 AM
 */
public class Employees {

	private List<Employee> empList = new ArrayList<>();
	private final EmployeeDao empDao = new EmployeeDaoImpl();

	public Employees() {
		empList.clear();
	}

	public List<Employee> getEmpList() {
		empList.clear();
		empList = empDao.getAllEmployees();
		return empList;
	}

	public int countEmployees() {
		return empDao.countEmployees();
	}

}
