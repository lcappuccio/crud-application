package org.systemexception.crudapplication.model;

/**
 * @author leo
 * @date Feb 18, 2015 12:24:00 AM
 */
public final class Employee {

	private int empId;
	private String empName, empSurname;

	public Employee() {
	}

	public Employee(String empName, String empSurname) {
		this.setEmpName(empName);
		this.setEmpSurname(empSurname);
	}

	public Employee(int empId, String empName, String empSurname) {
		this.empId = empId;
		this.setEmpName(empName);
		this.setEmpSurname(empSurname);
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSurname() {
		return empSurname;
	}

	public void setEmpSurname(String empSurname) {
		this.empSurname = empSurname;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 59 * hash + this.empId;
		hash = 59 * hash + (this.empName != null ? this.empName.hashCode() : 0);
		hash = 59 * hash + (this.empSurname != null ? this.empSurname.hashCode() : 0);
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
		final Employee other = (Employee) obj;
		if (this.empId != other.empId) {
			return false;
		}
		if ((this.empName == null) ? (other.empName != null) : !this.empName.equals(other.empName)) {
			return false;
		}
		return !((this.empSurname == null) ? (other.empSurname != null) : !this.empSurname.equals(other.empSurname));
	}
}
