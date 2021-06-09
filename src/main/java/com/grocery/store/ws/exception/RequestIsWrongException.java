package com.grocery.store.ws.exception;

public class RequestIsWrongException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequestIsWrongException(String message, String wrongField) {
		super(String.format(message, wrongField));
	}

}
