package com.awu.viewmodels;

public class JsonMsg {
	private boolean status;
	private String message;
	private int code;
	private Object data;

	public JsonMsg(boolean status, String message, int code, Object data) {
		setStatus(status);
		setMessage(message);
		setCode(code);
		setData(data);
	}

	public JsonMsg(boolean status, String message, int code) {
		setStatus(status);
		setMessage(message);
		setCode(code);
		data = null;
	}

	public JsonMsg(boolean status, String message) {
		setStatus(status);
		setMessage(message);
		code = 0;
		data = null;
	}

	public boolean getStatus() {
		return status;
	}

	protected void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	protected void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	protected void setData(Object data) {
		this.data = data;
	}
}
