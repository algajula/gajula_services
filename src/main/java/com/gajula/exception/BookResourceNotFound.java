package com.gajula.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Throwable cause;
	private String serviceName;
	
	public BookResourceNotFound(final String message, Throwable cause, String serviceName) {
		super(message);
		this.cause=cause;
		this.serviceName=serviceName;
	}

	public synchronized Throwable getCause() {
		return cause;
	}

	public synchronized void setCause(Throwable cause) {
		this.cause = cause;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
}
