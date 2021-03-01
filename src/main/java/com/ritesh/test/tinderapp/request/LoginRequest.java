package com.ritesh.test.tinderapp.request;

public class LoginRequest extends Request{
	private String emailId;
	private String password;
	
	public LoginRequest() {
		
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
