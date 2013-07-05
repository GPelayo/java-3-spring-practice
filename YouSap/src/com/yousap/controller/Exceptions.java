package com.yousap.controller;

public class Exceptions extends RuntimeException {
	
	private String exceptionMsg;
	 
	public Exceptions(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
	
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
