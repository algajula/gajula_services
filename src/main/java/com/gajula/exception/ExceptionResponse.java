package com.gajula.exception;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"statusCode","msg"})
@XmlRootElement(name = "lp_response")
public class ExceptionResponse {

	@XmlElement(name="statusCode", required=true)
	private String statusCode="02";

	@XmlElement(name="statusCodeDesc", required=true)
	private String statusCodeDesc="ERR";
	
	@XmlElement(name="result", required=true)
	private Object result="";
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusCodeDesc() {
		return statusCodeDesc;
	}
	public void setStatusCodeDesc(String statusCodeDesc) {
		this.statusCodeDesc = statusCodeDesc;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
