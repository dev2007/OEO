package com.awu.actions;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	public String execute(){
		System.out.println("Search");
		return SUCCESS;
	}
}
