package com.yousap.controller;

public class BlankFieldException extends RuntimeException {
	
	private String exceptionMsg;
	 
	public BlankFieldException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
	
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
