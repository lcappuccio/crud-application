package org.systemexception.crudapplication.pojo;

/**
 *
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
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empSurname == null) ? 0 : empSurname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		if (empId != other.empId) {
			return false;
		}
		if (empName == null) {
			if (other.empName != null) {
				return false;
			}
		} else if (!empName.equals(other.empName)) {
			return false;
		}
		if (empSurname == null) {
			if (other.empSurname != null) {
				return false;
			}
		} else if (!empSurname.equals(other.empSurname)) {
			return false;
		}
		return true;
	}
}
