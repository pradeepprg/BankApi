package com.tcs.ilp.exceptions;


public class ErrorMessage {
	
	private int status;
	private String message;
	private String url;
	
	public ErrorMessage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.url = "https://abcbankjpn.com/help";
	}
	
	public ErrorMessage(){
		super();
	}

	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", message=" + message + ", url=" + url + "]";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	


}
