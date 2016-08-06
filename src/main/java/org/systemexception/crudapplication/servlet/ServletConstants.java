package org.systemexception.crudapplication.servlet;

/**
 * @author leo
 * @date 06/08/16 10:28
 */
public enum ServletConstants {

	SERVLET_CONTENT("text/html;charset=UTF-8"),
	LOG_MESSAGE_EMPLOYEES(" employees"),
	LOG_MESSAGE_RETRIEVED("retrieved "),
	PARAMETER_EMP_ID("empID"),
	REQUEST_FROM("request from ");

	private final String constant;

	ServletConstants(final String constant) {
		this.constant = constant;
	}

	@Override
	public String toString() {
		return constant;
	}
}
