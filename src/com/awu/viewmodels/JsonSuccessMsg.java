package com.awu.viewmodels;

public class JsonSuccessMsg extends JsonMsg {

	public JsonSuccessMsg(String message, int code, Object data) {
		super(true, message, code, data);
	}
	
	public JsonSuccessMsg(String message,int code){
		super(true, message,code);
	}
	
	public JsonSuccessMsg(String message){
		super(true, message);
	}
}
