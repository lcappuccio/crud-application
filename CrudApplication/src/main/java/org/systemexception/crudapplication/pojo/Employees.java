package org.systemexception.crudapplication.pojo;

import java.util.ArrayList;
import java.util.List;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:46:35 AM
 */
public class Employees {

	private List<Employee> empList = new ArrayList<Employee>();
	private final EmployeeDaoImpl empDao = new EmployeeDaoImpl();

	public Employees() {
		empList.clear();
	}

	public List<Employee> getEmpList() {
		empList.clear();
		empList = empDao.getAllEmployees();
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public int countEmployees() {
		return empDao.countEmployees();
	}
}
