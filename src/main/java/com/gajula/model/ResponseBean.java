package com.gajula.model;

public class ResponseBean {

	private String statusCode="01";
	private String statusDescription="SUCCESS";
	private Object result;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "BookResponseBean [statusCode=" + statusCode + ", statusDescription=" + statusDescription + ", result="
				+ result + "]";
	}
	
	
}
