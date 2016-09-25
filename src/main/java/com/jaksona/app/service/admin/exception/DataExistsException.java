package com.jaksona.app.service.admin.exception;

/**
 * @author jaksona
 */
public class DataExistsException extends Exception {

	private final String MSG = "已存在！";

	/**
	 * Constructs a new exception with the specified detail message.  The
	 * cause is not initialized, and may subsequently be initialized by
	 * a call to {@link #initCause}.
	 *
	 * @param message the detail message. The detail message is saved for
	 *                later retrieval by the {@link #getMessage()} method.
	 */
	public DataExistsException(String message) {
		super(message);
	}
}
