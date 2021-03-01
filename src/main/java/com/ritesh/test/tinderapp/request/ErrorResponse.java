package com.ritesh.test.tinderapp.request;

public class ErrorResponse extends Response{	
	private String msg;
	
	public ErrorResponse( ) {}
	
	public ErrorResponse(String msg) {
		this.msg = msg;
	}
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
