package com.grocery.store.ws.exception;

public class DataBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataBaseException(String message) {
		super(String.format(message));
	}

}
