package com.awu.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	public String execute(){
		System.out.println("Home");
		return SUCCESS;
	}
}
