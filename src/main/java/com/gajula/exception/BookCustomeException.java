package com.gajula.exception;

public class BookCustomeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Throwable cause;
	private String serviceName;
	
	public BookCustomeException(String message, Throwable cause, String serviceName) {
		super(message);
		this.cause=cause;
		this.serviceName=serviceName;
	}

	public BookCustomeException(final String message) {
		super(message);
	}
	
	public BookCustomeException(final Exception message) {
		super(message);
	}
	
	public BookCustomeException(final Object message) {
		super(message.toString());
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
