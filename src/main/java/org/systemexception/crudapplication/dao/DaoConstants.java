package org.systemexception.crudapplication.dao;

/**
 * @author leo
 * @date 06/08/16 10:35
 */
public enum DaoConstants {

	EMPLOYEE_ID("EMPLOYEE_ID"),
	EMPLOYEE_NAME("EMPLOYEE_NAME"),
	EMPLOYEE_SURNAME("EMPLOYEE_SURNAME");

	private final String constant;

	DaoConstants(final String constant) {
		this.constant = constant;
	}

	@Override
	public String toString() {
		return constant;
	}
}
