package org.systemexception.crudapplication.exception;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:49:26 AM
 */
public class PojoMapperException extends Exception {

	private static final long serialVersionUID = -5757918482309489166L;

	public PojoMapperException() {
	}

	/**
	 * PojoMapper throwable
	 *
	 * @param msg
	 */
	public PojoMapperException(String msg) {
		super(msg);
	}

	/**
	 * PojoMapper throwable
	 *
	 * @param message
	 * @param throwable
	 */
	public PojoMapperException(String message, Throwable throwable) {
		super(message, throwable);
	}
}