package com.waycourier.app.to;

public class ErrorMessage {
	public ErrorMessage(int statusCode, String statusVal, String errMessage) {
		super();
		this.statusCode = statusCode;
		this.statusVal = statusVal;
		this.errMessage = errMessage;
	}
	int statusCode;
	String statusVal;
	String errMessage;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusVal() {
		return statusVal;
	}
	public void setStatusVal(String statusVal) {
		this.statusVal = statusVal;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	
}
