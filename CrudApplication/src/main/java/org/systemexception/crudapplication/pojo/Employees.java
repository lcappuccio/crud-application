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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + (this.empList != null ? this.empList.hashCode() : 0);
		hash = 71 * hash + (this.empDao != null ? this.empDao.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Employees other = (Employees) obj;
		if (this.empList != other.empList && (this.empList == null || !this.empList.equals(other.empList))) {
			return false;
		}
		return !(this.empDao != other.empDao && (this.empDao == null || !this.empDao.equals(other.empDao)));
	}

}
