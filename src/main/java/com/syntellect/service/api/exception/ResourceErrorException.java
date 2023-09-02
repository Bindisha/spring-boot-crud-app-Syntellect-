package com.syntellect.service.api.exception;

public class ResourceErrorException extends RuntimeException{
	public ResourceErrorException(String message) {
		super(message);
	}

	public ResourceErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceErrorException(Throwable cause) {
		super(cause);
	}
}
