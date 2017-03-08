package com.awu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awu.models.User;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public User addUser() {
		User obj = new User();
		obj.setId("321");
		obj.setName("test");
		return obj;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser() {
		throw new NotImplementedException();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPWD() {
		throw new NotImplementedException();
	}
}
