package org.systemexception.crudapplication.servlet;

/**
 * @author leo
 * @date 06/08/16 10:28
 */
public enum ServletConstants {

	SERVLET_CONTENT("text/html;charset=UTF-8");

	private final String constant;

	ServletConstants(final String constant) {
		this.constant = constant;
	}

	@Override
	public String toString() {
		return constant;
	}
}
