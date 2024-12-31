package com.gajula.exception;

public class InternalServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Throwable cause;
    private String serviceName;
    private int currentRowNumber;

    public InternalServerException(String message, Throwable cause, String serviceName, int currentRowNumber) {
        super(message);
        this.cause = cause;
        this.serviceName = serviceName;
        this.currentRowNumber = currentRowNumber;
    }

    public InternalServerException(final String message) {
        super(message);
    }

    public InternalServerException(final Exception message) {
        super(message);
    }

    public InternalServerException(final Object message) {
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

    public int getCurrentRowNumber() {
        return currentRowNumber;
    }

    public void setCurrentRowNumber(int currentRowNumber) {
        this.currentRowNumber = currentRowNumber;
    }
}