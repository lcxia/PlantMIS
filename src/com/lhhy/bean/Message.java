package com.lhhy.bean;

public class Message {
	private boolean success;
	private String errorMsg;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Message() {
		super();
	}

	public Message(boolean success, String errorMsg) {
		super();
		this.success = success;
		this.errorMsg = errorMsg;
	}

}
