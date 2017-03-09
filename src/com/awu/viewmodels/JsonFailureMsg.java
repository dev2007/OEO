package com.awu.viewmodels;

public class JsonFailureMsg extends JsonMsg {

	public JsonFailureMsg(String message, int code, Object data) {
		super(false, message, code, data);
	}

	public JsonFailureMsg(String message, int code) {
		super(false, message, code);
	}

	public JsonFailureMsg(String message) {
		super(false, message);
	}
}
